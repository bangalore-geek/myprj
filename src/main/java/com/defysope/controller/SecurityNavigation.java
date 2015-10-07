package com.defysope.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.defysope.model.User;
import com.defysope.service.ApplicationUtils;
import com.defysope.service.UserService;
import com.defysope.service.impl.Navigation;

@Controller
public class SecurityNavigation {

	@Autowired
	private ApplicationUtils utils;

	@Autowired
	private Navigation navigation;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user-login", method = RequestMethod.GET)
	public ModelAndView loginForm() {
		return new ModelAndView("login-form");
	}

	@RequestMapping(value = "/error-login", method = RequestMethod.GET)
	public ModelAndView invalidLogin() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("error", true);
		return new ModelAndView("login-form", map);
	}

	@RequestMapping(value = "/success-login", method = RequestMethod.GET)
	public ModelAndView successLogin() {
		String page = "home";
		Map<String, Object> model = new HashMap<String, Object>();
		User loggedInUser = utils.getLoggedInUser();
		model.put("user", loggedInUser);
		model.put("menus", navigation.displayMenuList());
		model.put("productlist", userService.getProductList(utils.getLoggedInUser().getCmpId()));
		if (loggedInUser.getUserType() == User.CORPORATE_TRAINEE) {
			page = "kv/attend-test";
		}
		if (loggedInUser.getUserType() == User.INTERVIEW_CANDIDATE) {
			page = "/kv/schedule-interview";
		}
		return new ModelAndView(page, model);
	}

	@RequestMapping(value = "/access-denied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("access-denied");
	}
}
