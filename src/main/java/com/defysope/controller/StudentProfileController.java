package com.defysope.controller;

import java.util.HashMap;
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

import com.defysope.model.OtherEducation;
import com.defysope.model.StudentDetails;
import com.defysope.model.User;
import com.defysope.model.WorkHistory;
import com.defysope.navigation.Menu;
import com.defysope.service.ApplicationUtils;
import com.defysope.service.PublicManager;
import com.defysope.service.UserService;
import com.defysope.service.impl.Navigation;

@Controller
public class StudentProfileController {

	@Autowired
	private PublicManager manager;

	@Autowired
	private UserService userService;

	@Autowired
	private ApplicationUtils utils;

	@Autowired
	private Navigation navigation;

	// displaying the add student details form
	@Menu(title = "Student Profile", url = "/student-profile", accessCode = "ROLE_DF_STUDENT_PROFILE", order = 1, visible = true)
	@RequestMapping(value = "/student-profile", method = RequestMethod.GET)
	@Secured("ROLE_DF_HOME_PAGE")
	public ModelAndView loadFtl(HttpServletRequest request) {

		User user = utils.getLoggedInUser();

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());

		model.put("userDetail", userService.getStudentDetails(user.getId()));

		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("student-profile", model);
	}

	@RequestMapping(value = "/load-student-detail", method = RequestMethod.GET)
	@Secured("ROLE_DF_HOME_PAGE")
	@ResponseBody
	public Object loadData(HttpServletRequest request) {
		User user = utils.getLoggedInUser();
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("userDetail", userService.getStudentDetails(user.getId()));
		model.put("userWorkHistoryDetail", userService.getWorkHistoryDetails(user.getId()));
		model.put("userAddressDetail", userService.getAddressDetails(user.getId()));
		model.put("userEducationDetail", userService.getEducationDetails(user.getId()));
		
		return model;
	}
	
	@RequestMapping(value = "/save-student-profile", method = RequestMethod.POST)
	@Secured("ROLE_DF_HOME_PAGE")
	@ResponseBody
	public Object updateData(HttpServletRequest request, @RequestBody StudentDetails studentDetails) {
		User user = utils.getLoggedInUser();
		manager.saveObject(studentDetails);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("success", true);
		return model;
	}
	
	@RequestMapping(value = "/save-student-education", method = RequestMethod.POST)
	@Secured("ROLE_DF_HOME_PAGE")
	@ResponseBody
	public Object updateData(HttpServletRequest request, @RequestBody OtherEducation otherEducation) {
		User user = utils.getLoggedInUser();
		manager.saveObject(otherEducation);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("success", true);
		return model;
	}
	
	@RequestMapping(value = "/save-student-workhistory", method = RequestMethod.POST)
	@Secured("ROLE_DF_HOME_PAGE")
	@ResponseBody
	public Object updateData(HttpServletRequest request, @RequestBody WorkHistory workHistory) {
		User user = utils.getLoggedInUser();
		manager.saveObject(workHistory);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("success", true);
		return model;
	}
}