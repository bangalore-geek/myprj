package com.defysope.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.defysope.service.BookmarkUtils;

@Controller
public class SecurityNavigation {

	@Autowired
	private BookmarkUtils utils;

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
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		return new ModelAndView("home", model);
	}

	@RequestMapping(value = "/access-denied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("access-denied");
	}

}
