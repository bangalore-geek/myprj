package com.defysope.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.defysope.model.User;
import com.defysope.navigation.Menu;
import com.defysope.service.ApplicationUtils;
import com.defysope.service.AssesmentService;
import com.defysope.service.UserService;
import com.defysope.service.impl.Navigation;

@Controller
public class TrainingAttendanceController {
	
	@Autowired
	private ApplicationUtils utils;
	
	@Autowired
	private Navigation navigation;
	
	@Autowired
	private AssesmentService assesmentService;
	
	@Menu(title = "Training Attendance", url = "/corpyogi/kv/trainingattendance", accessCode = "ROLE_DF_CREATE_ROLE", order = 1, visible = true)
	@RequestMapping(value = "/corpyogi/kv/trainingattendance", method = RequestMethod.GET)
	@Secured("ROLE_DF_CREATE_ROLE")
	public ModelAndView trainingAttandanceFtl(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("training-attendance", model);
	}
	
	@Menu(title = "Training Attendance", url = "/corpyogi/kv/assesment", accessCode = "ROLE_DF_CREATE_ROLE", order = 1, visible = true)
	@RequestMapping(value = "/corpyogi/kv/assesment", method = RequestMethod.GET)
	@Secured("ROLE_DF_CREATE_ROLE")
	public ModelAndView trainingAssesmentFtl(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("training-assessment", model);
	}
	
	@RequestMapping(value = "/load-trainings", method = RequestMethod.GET)
	@Secured("ROLE_DF_HOME_PAGE")
	@ResponseBody
	public Object loadData(HttpServletRequest request) {
		User user = utils.getLoggedInUser();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("trainingList", assesmentService.getAssesmentForOrganization(1));
		return model;
	}
	
	
	@RequestMapping(value = "/load-course", method = RequestMethod.GET)
	@Secured("ROLE_DF_HOME_PAGE")
	@ResponseBody
	public Object loadCourse(HttpServletRequest request) {
		User user = utils.getLoggedInUser();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("courseList", assesmentService.getAssesmentMaster());
		return model;
	}
	
	@RequestMapping(value = "/load-training-for-course", method = RequestMethod.GET)
	@Secured("ROLE_DF_HOME_PAGE")
	@ResponseBody
	public Object loadTraining(HttpServletRequest request, @RequestParam int courseId) {
		User user = utils.getLoggedInUser();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("trainingList", assesmentService.getAssesmentCourses(courseId));
		return model;
	}

}
