package com.defysope.controller.kv;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.defysope.Constant;
import com.defysope.model.User;
import com.defysope.model.kv.Requirement;
import com.defysope.model.kv.Trainee;
import com.defysope.navigation.Menu;
import com.defysope.service.ApplicationUtils;
import com.defysope.service.AssesmentService;
import com.defysope.service.PublicManager;
import com.defysope.service.RequirementService;
import com.defysope.service.UserService;
import com.defysope.service.impl.Navigation;

@Controller
public class ConfigureInterviewController {

	@Autowired
	private ApplicationUtils utils;
	
	@Autowired
	private Navigation navigation;
	
	@Autowired
	private PublicManager manager;
	
	@Autowired
	private RequirementService requirementService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AssesmentService assesmentService;
	
	@Menu(title = "Configure Interview", url = "/kv/configure-interview", accessCode = "ROLE_DF_CONFIGURE_INTERVIEW", order = 9, visible = true)
    @RequestMapping(value = "/kv/configure-interview", method = RequestMethod.GET)
    @Secured("ROLE_DF_CONFIGURE_INTERVIEW")
    public ModelAndView configureRequiremetn(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
        return new ModelAndView("kv/configure-interview", model);
    }
    
	@RequestMapping(value = "/kv/save-requirement", method = RequestMethod.POST)
	@Secured("ROLE_DF_CONFIGURE_INTERVIEW")
	@ResponseBody
	public Object saveRequirement(HttpServletRequest request, @RequestBody Requirement thisRequirement) {
		thisRequirement.setCompId(utils.getLoggedInUser().getComId());
		manager.saveObject(thisRequirement);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("thisRequirement", thisRequirement);
		model.put("success", true);
		return model;
	}

	@RequestMapping(value = "/kv/load-requirement-list", method = RequestMethod.GET)
	@Secured("ROLE_DF_CONFIGURE_INTERVIEW")
	@ResponseBody
	public Object loadEditRequiremetnList(HttpServletRequest request) { 
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("requirementList", requirementService.getRequirementForCompany(utils.getLoggedInUser().getComId()));
		return model;
	}
	
	@RequestMapping(value = "/kv/save-candidate", method = RequestMethod.POST)
	@Secured("ROLE_DF_CONFIGURE_INTERVIEW")
	@ResponseBody
	public Object saveTrainee(HttpServletRequest request, @RequestBody Trainee candidate) {
		// loading Requirement
		Requirement requirement = (Requirement) manager.getObjectOrNull(Requirement.class, candidate.getRequirementId());
		
		candidate.setCourseId(1);
		candidate.setTrainingId(1);
		
		candidate.setCompId(utils.getLoggedInUser().getComId());
		candidate.setStartDate(requirement.getStartDate());
		candidate.setEndDate(requirement.getEndDate());
		candidate.setPassword(utils.encryptPassword("sa"));
		
		User newUser = new User();
		newUser.setUserName(candidate.getEmail());
		newUser.setPassword(utils.encryptPassword("sa"));
		newUser.setUserType(User.INTERVIEW_CANDIDATE);
		manager.saveObject(newUser);
		candidate.setUserId(newUser.getId());
		manager.saveObject(candidate);
		
		userService.saveUserInfo(newUser, Constant.ROLE_INTERVIEW_CANDIDATE);
		
		// loading trainee list for particular training
		//List<Trainee> thisRequirementCandidateList = assesmentService.getTraineeList(trainee.getTrainingId());
		Map<String, Object> model = new HashMap<String, Object>();
		//model.put("thisRequirementCandidateList", thisRequirementCandidateList);
	
		return model;
	}
	
	/* ======= load trainee list for wizard last step ======= */
	@RequestMapping(value = "/kv/load-candidate-list", method = RequestMethod.GET)
	@Secured("ROLE_DF_CONFIGURE_INTERVIEW")
	@ResponseBody
	public Object loadTrainee(HttpServletRequest request, @RequestParam int requirementId) {
		List<Trainee> candidateList = assesmentService.getCandidateList(utils.getLoggedInUser().getComId(), requirementId);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("candidateList", candidateList);
		return model;
	}
}