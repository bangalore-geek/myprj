package com.defysope.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.defysope.navigation.Menu;
import com.defysope.service.ApplicationUtils;
import com.defysope.service.AssesmentService;
import com.defysope.service.impl.Navigation;

@Controller
public class OnlineTestController {
	
	@Autowired
	private ApplicationUtils utils;
	
	@Autowired
	private AssesmentService assesmentService;
	
	@Autowired
	private Navigation navigation;
	
	@Menu(title = "Course List", url = "/corpyogi/kv/test", accessCode = "ROLE_DF_CREATE_ROLE", order = 1, visible = true)
	@RequestMapping(value = "/corpyogi/kv/test", method = RequestMethod.GET)
	@Secured("ROLE_DF_HOME_PAGE")
	public ModelAndView createRole(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("test-wizard", model); 
	}

}
