package com.defysope.controller.kv;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.defysope.model.User;
import com.defysope.model.kv.Course;
import com.defysope.model.kv.Trainee;
import com.defysope.model.kv.Training;
import com.defysope.navigation.Menu;
import com.defysope.service.ApplicationUtils;
import com.defysope.service.AssesmentService;
import com.defysope.service.PublicManager;
import com.defysope.service.UserService;
import com.defysope.service.impl.Navigation;

@Controller
public class ConfigureAssessmentController {

	@Autowired
	private PublicManager manager;
	
	@Autowired
	private ApplicationUtils utils;

	@Autowired
	private Navigation navigation;
	
	@Autowired
	private AssesmentService assesmentService;	
	
	@Autowired
	private UserService userService;
	
	@Menu(title = "Configure Assessment", url = "/kv/configure-assessment?editCourseId=0&editTrainingId=0", accessCode = "ROLE_DF_CONFIGURE_ASSESSMENT", order = 7, visible = true)
	@RequestMapping(value = "/kv/configure-assessment", method = RequestMethod.GET)
	@Secured("ROLE_DF_CONFIGURE_ASSESSMENT")
	public ModelAndView loadWizardFtl(HttpServletRequest request, @RequestParam Integer editCourseId, @RequestParam Integer editTrainingId) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("editCourseId", editCourseId);
		model.put("editTrainingId", editTrainingId);
		
		HttpSession session = request.getSession();
		session.setAttribute("editCourseId", editCourseId);
		session.setAttribute("editTrainingId", editTrainingId);
		
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("/kv/configure-assessment", model);
	}
	
	//=====================Validate trainee =======================
	@RequestMapping(value = "/kv/validate/trainee", method = RequestMethod.GET)
	@Secured("ROLE_DF_CONFIGURE_ASSESSMENT_TRAINEE")
	@ResponseBody
	public Object checkTraineeName(HttpServletRequest request,  @RequestParam String traineeName) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("success", true);
		Trainee thisTrainee =  assesmentService.getTraineeByEmail(traineeName);
		if (thisTrainee == null) {
			model.put("success", true);
		} else {
			model.put("success", false);
		}
		return model;
	}
	
	//=====================Save related code =======================
	@RequestMapping(value = "/kv/save-course", method = RequestMethod.POST)
	@Secured("ROLE_DF_CONFIGURE_ASSESSMENT_COURSE")
	@ResponseBody
	public Object saveCourse(HttpServletRequest request, @RequestBody Course thisCourse) {
		thisCourse.setOrgId(1);
		manager.saveObject(thisCourse);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("thisCourse", thisCourse);
		model.put("success", true);
		return model;
	}
	
	@RequestMapping(value = "/kv/save-training", method = RequestMethod.POST)
	@Secured("ROLE_DF_CONFIGURE_TRAINING")
	@ResponseBody
	public Object saveTraining(HttpServletRequest request, @RequestBody Training thisTraining) {
		manager.saveObject(thisTraining);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("thisTraining", thisTraining);
		// getting training list for particuLAr course
		model.put("trainingList", assesmentService.getAssesmentCourses(thisTraining.getAssesmentMasterId()));
		model.put("success", true);
		return model;
	}
	
	@RequestMapping(value = "/kv/save-trainee", method = RequestMethod.POST)
	@Secured("ROLE_DF_CONFIGURE_ASSESSMENT_TRAINEE")
	@ResponseBody
	public Object saveTrainee(HttpServletRequest request, @RequestBody Trainee trainee) {
		// loading training
		Training assesmentCourse = (Training) manager.getObjectOrNull(Training.class, trainee.getTrainingId());
		trainee.setCourseId(assesmentCourse.getAssesmentMasterId());
		
		trainee.setStartDate(assesmentCourse.getStartdate());
		trainee.setEndDate(assesmentCourse.getEnddate());
		trainee.setPassword(utils.encryptPassword("sa"));
		
		User newUser = new User();
		newUser.setUserName(trainee.getEmail());
		newUser.setPassword(utils.encryptPassword("sa"));
		newUser.setUserType(2);
		manager.saveObject(newUser);
		trainee.setUserId(newUser.getId());
		manager.saveObject(trainee);
		
		userService.saveUserInfo(newUser);
		
		// loading trainee list for particular training
		List<Trainee> traineeList = assesmentService.getTraineeList(trainee.getTrainingId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("traineeList", traineeList);
	
		return model;
	}
	
	/*=============================Edit related code ==========================================*/
	@RequestMapping(value = "/kv/load-edit-course", method = RequestMethod.GET)
	@Secured("ROLE_DF_CONFIGURE_ASSESSMENT_COURSE")
	@ResponseBody
	public Object loadEditCourse(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int editCourseId = (int) session.getAttribute("editCourseId");
		model.put("editCourseId", editCourseId);
		
		if (editCourseId > 0) {
			Course assesmentMaster = (Course) manager.getObjectOrNull(Course.class, editCourseId);
			model.put("thisCourse", assesmentMaster);
			model.put("trainingList", assesmentService.getAssesmentCourses(editCourseId));
		}
		return model;
	}
	
	@RequestMapping(value = "/kv/load-edit-training", method = RequestMethod.GET)
	@Secured("ROLE_DF_CONFIGURE_ASSESSMENT_TRAINING")
	@ResponseBody
	public Object loadEditTraining(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		model.put("courseId", session.getAttribute("courseId"));
		
		int editTrainingId = (int) session.getAttribute("editTrainingId");
		if (editTrainingId > 0) {
			model.put("editTrainingId", editTrainingId);
			Training assesmentCourse = (Training) manager.getObjectOrNull(Training.class, editTrainingId);
			model.put("thisTraining", assesmentCourse);
		}
		return model;
	}
	
	/* ======= load trainee list for wizard last step ======= */
	@RequestMapping(value = "/kv/load-trainee-list", method = RequestMethod.GET)
	@Secured("ROLE_DF_CONFIGURE_ASSESSMENT_TRAINEE")
	@ResponseBody
	public Object loadTrainee(HttpServletRequest request, @RequestParam int trainingId) {
		List<Trainee> traineeList = assesmentService.getTraineeList(trainingId);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("traineeList", traineeList);
		return model;
	}

	/* ===========================Delete trainee ================= */
	@RequestMapping(value = "/kv/delete-trainee/{id}", method = RequestMethod.DELETE)
	@Secured("ROLE_DF_CONFIGURE_ASSESSMENT_TRAINEE")
	@ResponseBody
	public Object deleteTrainee(HttpServletRequest request,  @PathVariable Integer id) {
		Map<String, Object> model = new HashMap<String, Object>();
		manager.removeObject(Trainee.class, id);
		model.put("success", true);
		return model;
	}
	
	/* ===========================load assessment type ================= */
	@RequestMapping(value = "/kv/load-assesmentType", method = RequestMethod.GET)
	@Secured("ROLE_DF_CONFIGURE_ASSESSMENT")
	@ResponseBody
	public Object loadAssesementType(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("viewAssesmentTypeList", assesmentService.getAssesmentType());
		return model;
	}
	
	
	@RequestMapping(value = "/kv/has-access-right", method = RequestMethod.GET)
	@ResponseBody
	public Object hasAccessRight(HttpServletRequest request) {
		System.out.println("has access right comed >>>>>>>>>>");
		Map<String, Object> model = new HashMap<String, Object>();
		userService.hasAccessRight(utils.getLoggedInUser(), "");
		return model;
	}
	
}