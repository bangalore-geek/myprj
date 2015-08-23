package com.defysope.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.defysope.model.AssesmentCourse;
import com.defysope.model.AssesmentMaster;
import com.defysope.model.User;
import com.defysope.navigation.Menu;
import com.defysope.service.ApplicationUtils;
import com.defysope.service.AssesmentService;
import com.defysope.service.PublicManager;

@Controller
public class AssesmentController {
	
	@Autowired
	private PublicManager manager;
	
	@Autowired
	private ApplicationUtils utils;
	
	@Autowired
	private AssesmentService assesmentService;
	
	// displaying the list of assessment
	@Menu(title = "Assesment List", url = "/assesment-list", accessCode = "ROLE_DF_STUDENT_PROFILE", order = 1, visible = true)
	@RequestMapping(value = "/assesment-list", method = RequestMethod.GET)
	@Secured("ROLE_DF_HOME_PAGE")
	public ModelAndView loadFtl(HttpServletRequest request) {

		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("assesment-list", model);
	}
	
	@RequestMapping(value = "/load-assesement", method = RequestMethod.GET)
	@Secured("ROLE_DF_HOME_PAGE")
	@ResponseBody
	public Object loadAssesement(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<AssesmentMaster> assesmentCourses = assesmentService.getAssesmentMaster(); 
		for (AssesmentMaster am : assesmentCourses) {
			
		}
		model.put("viewAssesmentList",assesmentCourses );
		return model;
	}
	
	@RequestMapping(value = "/load-assesmentType", method = RequestMethod.GET)
	@Secured("ROLE_DF_HOME_PAGE")
	@ResponseBody
	public Object loadAssesementType(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("viewAssesmentTypeList", assesmentService.getAssesmentType());
		return model;
	}
	
	@RequestMapping(value = "/save-assesement", method = RequestMethod.POST)
	@Secured("ROLE_DF_HOME_PAGE")
	@ResponseBody
	public Object updateAssesement(HttpServletRequest request, @RequestBody AssesmentMaster assesmentMaster) {
		User user = utils.getLoggedInUser();
		assesmentMaster.setOrgId(1);
		manager.saveObject(assesmentMaster);
		System.out.println("id >>>>>>>>>>>> "+assesmentMaster.getId());
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("newCourseId", assesmentMaster.getId());
		model.put("success", true);
		return model;
	}
	
	// displaying list of course assesement
	@Menu(title = "Assesment course List", url = "/assesment-course-list", accessCode = "ROLE_DF_STUDENT_PROFILE", order = 1, visible = true)
	@RequestMapping(value = "/assesment-course-list", method = RequestMethod.GET)
	@Secured("ROLE_DF_HOME_PAGE")
	public ModelAndView loadCourseFtl(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("assesment-course-list", model);
	}

	@RequestMapping(value = "/load-course-assesement", method = RequestMethod.GET)
	@Secured("ROLE_DF_HOME_PAGE")
	@ResponseBody
	public Object loadCourseAssesement(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("viewCourseAssesmentList", assesmentService.getAssesmentCourses(0));
		return model;
	}
	
	@RequestMapping(value = "/save-assesement-course", method = RequestMethod.POST)
	@Secured("ROLE_DF_HOME_PAGE")
	@ResponseBody
	public Object updateAssesementCourses(HttpServletRequest request, @RequestBody AssesmentCourse assesmentCourse) {
		manager.saveObject(assesmentCourse);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("success", true);
		return model;
	}
	
	
	@RequestMapping(value = "/delete-assesement-course/{id}", method = RequestMethod.DELETE)
	@Secured("ROLE_DF_HOME_PAGE")
	@ResponseBody
	public Object deleteAssesementCourse(HttpServletRequest request,  @PathVariable Integer id) {
		Map<String, Object> model = new HashMap<String, Object>();
		manager.removeObject(AssesmentCourse.class, id);
		model.put("viewCourseAssesmentList", assesmentService.getAssesmentCourses(0));
		return model;
	}
}