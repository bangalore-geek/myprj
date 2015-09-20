
package com.defysope.controller.skillset;

import java.util.HashMap;
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

import com.defysope.model.StudentDetails;
import com.defysope.model.User;
import com.defysope.model.skillset.Education;
import com.defysope.model.skillset.WorkHistory;
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
		model.put("profile", userService.getStudentDetails(user.getId()));
		model.put("userAddressDetail", userService.getAddressDetails(user.getId()));
		return model;
	}
	
	@RequestMapping(value = "/save-student-profile", method = RequestMethod.POST)
	@Secured("ROLE_DF_HOME_PAGE")
	@ResponseBody
	public Object updateData(HttpServletRequest request, @RequestBody StudentDetails studentDetails) {
		manager.saveObject(studentDetails);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("success", true); 
		return model;
	} 
	
	@RequestMapping(value = "/save-student-education", method = RequestMethod.POST)
	@Secured("ROLE_DF_HOME_PAGE")
	@ResponseBody
	public Object updateData(HttpServletRequest request, @RequestBody Education education) {
		User user = utils.getLoggedInUser();
		education.setUserId(user.getId());
		manager.saveObject(education);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("success", true);
		return model;
	}
	
	@RequestMapping(value = "/load-student-workhistory", method = RequestMethod.GET)
	@Secured("ROLE_DF_HOME_PAGE")
	@ResponseBody
	public Object loadStudentWorkHistory(HttpServletRequest request) {
		User user = utils.getLoggedInUser();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("viewWorkhistory", userService.getWorkHistoryDetails(user.getId()));
		return model;
	}
	
	@RequestMapping(value = "/load-student-education", method = RequestMethod.GET)
	@Secured("ROLE_DF_HOME_PAGE")
	@ResponseBody
	public Object loadStudentEducation(HttpServletRequest request) {
		User user = utils.getLoggedInUser();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("viewEducation", userService.getEducationDetails(user.getId()));
		return model;
	}	
	
	@RequestMapping(value = "/load-student-references", method = RequestMethod.GET)
	@Secured("ROLE_DF_HOME_PAGE")
	@ResponseBody
	public Object loadStudentReferences(HttpServletRequest request) {
		User user = utils.getLoggedInUser();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("viewReferences", userService.getReferencesDetails(user.getId()));
		return model;
	}
	
	@RequestMapping(value = "/load-university", method = RequestMethod.GET)
	@Secured("ROLE_DF_HOME_PAGE")
	@ResponseBody
	public Object loadUniversity(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("viewUniversity", userService.getUniversity());
		return model;
	}
	
	@RequestMapping(value = "/save-student-workhistory", method = RequestMethod.POST)
	@Secured("ROLE_DF_HOME_PAGE")
	@ResponseBody
	public Object updateData(HttpServletRequest request, @RequestBody WorkHistory workHistory) {
		System.out.println("Sve called  work history >>>>>>>>>>");
		User user = utils.getLoggedInUser();
		workHistory.setUserId(user.getId());
		manager.saveObject(workHistory);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("success", true);
		return model;
	}
	
	@RequestMapping(value = "/delete-student-workhistory/{id}", method = RequestMethod.DELETE)
	@Secured("ROLE_DF_HOME_PAGE")
	@ResponseBody
	public Object deleteStudentworkhistory(HttpServletRequest request,  @PathVariable Integer id) {
		Map<String, Object> model = new HashMap<String, Object>();
		manager.removeObject(WorkHistory.class, id);
		model.put("message", "Work history was successfully deleted.");
		model.put("success", true);
		User user = utils.getLoggedInUser();
		model.put("viewWorkhistory", userService.getWorkHistoryDetails(user.getId()));
		return model;
	}
	
	@RequestMapping(value = "/delete-student-education/{id}", method = RequestMethod.DELETE)
	@Secured("ROLE_DF_HOME_PAGE")
	@ResponseBody
	public Object deleteStudentEducation(HttpServletRequest request,  @PathVariable Integer id) {
		Map<String, Object> model = new HashMap<String, Object>();
		manager.removeObject(Education.class, id);
		model.put("message", "Education was successfully deleted.");
		model.put("success", true);
		User user = utils.getLoggedInUser();
		model.put("viewEducation", userService.getEducationDetails(user.getId()));
		return model;
	}
}