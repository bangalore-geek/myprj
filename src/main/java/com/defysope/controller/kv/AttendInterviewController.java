package com.defysope.controller.kv;

import java.sql.Timestamp;
import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.defysope.model.kv.Candidate;
import com.defysope.model.kv.Company;
import com.defysope.navigation.Menu;
import com.defysope.service.ApplicationUtils;
import com.defysope.service.AssesmentService;
import com.defysope.service.PublicManager;
import com.defysope.service.RequirementService;
import com.defysope.service.UserService;
import com.defysope.service.impl.Navigation;

@Controller
public class AttendInterviewController {

	@Autowired
	private ApplicationUtils utils;
	
	@Autowired
	private Navigation navigation;
	
	@Autowired
	private PublicManager manager;
	
	@Autowired
	private RequirementService requirementService;
	
	@Autowired
	private AssesmentService assesmentService;
	
	@Autowired
	private UserService userService;
	
	@Menu(title = "Schedule Interview", url = "/kv/candidate/schedule-interview", accessCode = "ROLE_DF_ATTEND_INTERVIEW", order = 4, visible = true)
	@RequestMapping(value = "/kv/candidate/schedule-interview", method = RequestMethod.GET)
	@Secured("ROLE_DF_ATTEND_INTERVIEW")
	public ModelAndView scheduleInterview(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("/kv/schedule-interview", model); 
	}
	
	@Menu(title = "My Profile", url = "/kv/candidate/profile", accessCode = "ROLE_DF_ATTEND_INTERVIEW", order = 9, visible = true)
    @RequestMapping(value = "/kv/candidate/profile", method = RequestMethod.GET)
    @Secured("ROLE_DF_ATTEND_INTERVIEW")
    public ModelAndView candidateProfile(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		model.put("productlist", userService.getProductList(utils.getLoggedInUser().getCmpId()));
        return new ModelAndView("kv/candidate-profile", model);
    }
	
	//@Menu(title = "Start Interview", url = "/kv/candidate/start-interview", accessCode = "ROLE_DF_ATTEND_INTERVIEW", order = 12, visible = true)
    @RequestMapping(value = "/kv/candidate/start-interview", method = RequestMethod.GET)
    @Secured("ROLE_DF_ATTEND_INTERVIEW")
    public ModelAndView takeInterview(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		model.put("productlist", userService.getProductList(utils.getLoggedInUser().getCmpId()));
        return new ModelAndView("kv/start-interview", model);
    }	
    
	@RequestMapping(value = "/kv/candidate/load-interview-data", method = RequestMethod.GET)
	@Secured("ROLE_DF_ATTEND_INTERVIEW")
	@ResponseBody
	public Object loadInterviewData(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		
		
		boolean isElegible = false;
		Candidate thisCandidate = requirementService.getCandidateByUserId(utils.getLoggedInUser().getId());

 		Date today = new Timestamp(System.currentTimeMillis());
 		  if (today.after(thisCandidate.getStartDate()) && today.before(thisCandidate.getEndDate())) {
			isElegible = true;
		}
		
 		// if eligible for test then load questions
		if (isElegible) {
			List<Map<String, Object>> questionList = assesmentService.getQuestion();
			model.put("questionList", questionList);
		}
		
		model.put("elegibleForTest", isElegible);
		model.put("elegibleForInterview", isElegible);
		return model;
	}
	
	@RequestMapping(value = "/kv/load-candidate", method = RequestMethod.GET)
	@Secured("ROLE_DF_ATTEND_INTERVIEW")
	@ResponseBody
	public Object loadCandidate(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("thisCandidate", utils.getLoggedInUser());
		return model;
	}
	
	@RequestMapping(value = "/kv/laod-schedule-interview-data", method = RequestMethod.GET)
	@Secured("ROLE_DF_ATTEND_INTERVIEW")
	@ResponseBody
	public Object loadData(HttpServletRequest request) {
		Company thisCompany = (Company) manager.getObjectOrNull(Company.class,  utils.getLoggedInUser().getCmpId());
		Candidate thisCandidate = requirementService.getCandidateByUserId(utils.getLoggedInUser().getId());
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("thisCompany", thisCompany);
		model.put("thisCandidate", thisCandidate);
		return model;
	}

	@RequestMapping(value = "/kv/edit/candidate", method = RequestMethod.POST)
	@Secured("ROLE_DF_ATTEND_INTERVIEW")
	@ResponseBody
	public Object updateCAndidateProfile(HttpServletRequest request, @RequestBody Candidate thisCandidate) {
		manager.saveObject(thisCandidate);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("success", true); 
		return model;
	}

/*	@RequestMapping(value = "/kv/save-candidate-profile", method = RequestMethod.POST)
	@Secured("ROLE_DF_ATTEND_INTERVIEW")
	@ResponseBody
	public Object updateCAndidateProfile(HttpServletRequest request, @RequestBody Tr thisCompany) {
		manager.saveObject(thisCompany);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("success", true); 
		return model;
	} */
}
