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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.defysope.model.StudentDetails;
import com.defysope.model.kv.Company;
import com.defysope.model.kv.Course;
import com.defysope.model.kv.Training;
import com.defysope.navigation.Menu;
import com.defysope.service.ApplicationUtils;
import com.defysope.service.PublicManager;
import com.defysope.service.UserService;
import com.defysope.service.impl.Navigation;

@Controller
public class CompanyProfileController {

	@Autowired
	private ApplicationUtils utils;

	@Autowired
	private Navigation navigation;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PublicManager publicManager;

	@Menu(title = "Company Profile", url = "/kv/company-profile", accessCode = "ROLE_DF_COMPANY_PROFILE", order = 6, visible = true)
	@RequestMapping(value = "/kv/company-profile", method = RequestMethod.GET)
	@Secured("ROLE_DF_COMPANY_PROFILE")
	public ModelAndView createRole(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("/kv/company-profile", model);
	}
	
	@RequestMapping(value = "/kv/load-company", method = RequestMethod.GET)
	@Secured("ROLE_DF_COMPANY_PROFILE")
	@ResponseBody
	public Object loadCourses(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		Company thisCompany = (Company) publicManager.getObjectOrNull(Company.class, utils.getLoggedInUser().getComId());
		model.put("thisCompany", thisCompany );
		return model;
	}
	
	@RequestMapping(value = "/kv/save-company-profile", method = RequestMethod.POST)
	@Secured("ROLE_DF_COMPANY_PROFILE")
	@ResponseBody
	public Object updateData(HttpServletRequest request, @RequestBody Company thisCompany) {
		publicManager.saveObject(thisCompany);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("success", true); 
		return model;
	} 
}