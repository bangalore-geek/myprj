package com.defysope.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.defysope.model.AssesmentCourse;
import com.defysope.model.AssesmentMaster;
import com.defysope.model.StudentDetails;
import com.defysope.model.User;
import com.defysope.navigation.Menu;
import com.defysope.service.ApplicationUtils;
import com.defysope.service.AssesmentService;
import com.defysope.service.PublicManager;
import com.defysope.service.impl.Navigation;

@Controller
public class CourseListController {

	@Autowired
	private PublicManager manager; 
	
	@Autowired
	private ApplicationUtils utils;

	@Autowired
	private Navigation navigation;
	
	@Autowired
	private AssesmentService assesmentService;

	@Menu(title = "Course List", url = "/corpyogi/kv/courses", accessCode = "ROLE_DF_CREATE_ROLE", order = 1, visible = true)
	@RequestMapping(value = "/corpyogi/kv/courses", method = RequestMethod.GET)
	@Secured("ROLE_DF_CREATE_ROLE")
	public ModelAndView createRole(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("course-list", model);
	}
	
	
	// displaying the list of assessment
	@Menu(title = "Course Wizard", url = "/sample-wizard", accessCode = "ROLE_DF_STUDENT_PROFILE", order = 1, visible = true)
	@RequestMapping(value = "/sample-wizard", method = RequestMethod.GET)
	@Secured("ROLE_DF_HOME_PAGE")
	public ModelAndView loadWizard(HttpServletRequest request, @RequestParam Integer editCourseId, @RequestParam Integer editTrainingId) {
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("editCourseId", editCourseId);
		model.put("editTrainingId", editTrainingId);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("editCourseId", editCourseId);
		session.setAttribute("editTrainingId", editTrainingId);
		
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("sample-wizard", model);
	}
	
	@RequestMapping(value = "/edit-course-active", method = RequestMethod.POST)
	@Secured("ROLE_DF_HOME_PAGE")
	@ResponseBody
	public Object updateData(HttpServletRequest request, @RequestBody AssesmentMaster assesmentMaster) {
		System.out.println("comed >>>>>>>>>>>");
		boolean active = assesmentMaster.isActive();
		assesmentMaster.setActive(!active);
		
		manager.saveObject(assesmentMaster);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("success", true); 
		return model;
	} 
	
	@RequestMapping(value = "/load-edit-course", method = RequestMethod.GET)
	@Secured("ROLE_DF_CREATE_ROLE")
	@ResponseBody
	public Object cou(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int editCourseId = (int) session.getAttribute("editCourseId");
		model.put("editCourseId", editCourseId);
		System.out.println("editCourseId >>>>>>>>>> "+editCourseId);
		
		if (editCourseId > 0) {
			AssesmentMaster assesmentMaster = (AssesmentMaster) manager.getObjectOrNull(AssesmentMaster.class, editCourseId);
			model.put("editCourse", assesmentMaster);
			model.put("viewCourseAssesmentList", assesmentService.getAssesmentCourses(editCourseId));
		}
		return model;
	}

}
