package com.defysope.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.defysope.model.AssesmentCourse;
import com.defysope.model.AssesmentMaster;
import com.defysope.navigation.Menu;
import com.defysope.service.ApplicationUtils;
import com.defysope.service.AssesmentService;
import com.defysope.service.PublicManager;
import com.defysope.service.impl.Navigation;

@Controller
public class TrainingListController {

	@Autowired
	private PublicManager manager; 
	
	@Autowired
	private ApplicationUtils utils;

	@Autowired
	private Navigation navigation;

	@Autowired
	private AssesmentService assesmentService;

	@Menu(title = "Course List", url = "/corpyogi/kv/trainings", accessCode = "ROLE_DF_CREATE_ROLE", order = 1, visible = true)
	@RequestMapping(value = "/corpyogi/kv/trainings", method = RequestMethod.GET)
	@Secured("ROLE_DF_CREATE_ROLE")
	public ModelAndView createRole(HttpServletRequest request, @RequestParam Integer id) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("courseId", id);
		HttpSession session = request.getSession();
		session.setAttribute("courseId", id);
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("training-list", model);
	}

	@RequestMapping(value = "/corpyogi/kv/load-course-tranings", method = RequestMethod.GET)
	@Secured("ROLE_DF_CREATE_ROLE")
	@ResponseBody
	public Object cou(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int courseId = (int) session.getAttribute("courseId");
		model.put("viewCourseAssesmentList", assesmentService.getAssesmentCourses(courseId));
		model.put("courseId", courseId);
		return model;
	}
	
	
	@RequestMapping(value = "/load-edit-training", method = RequestMethod.GET)
	@Secured("ROLE_DF_CREATE_ROLE")
	@ResponseBody
	public Object trainingEdit(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		model.put("courseId", session.getAttribute("courseId"));
		
		int editTrainingId = (int) session.getAttribute("editTrainingId");
		if (editTrainingId > 0) {
			model.put("editTrainingId", editTrainingId);
			AssesmentCourse assesmentCourse = (AssesmentCourse) manager.getObjectOrNull(AssesmentCourse.class, editTrainingId);
			model.put("thisTraining", assesmentCourse);
		}
		return model;
	}
}
