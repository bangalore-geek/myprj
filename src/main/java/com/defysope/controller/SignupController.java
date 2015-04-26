package com.defysope.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.defysope.model.User;
import com.defysope.model.UserInfo;
import com.defysope.service.ApplicationUtils;
import com.defysope.service.PublicManager;

@Controller
public class SignupController {

	@Autowired
	private PublicManager manager;

	@Autowired
	private ApplicationUtils utils;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView getSignUpForm() {
		return new ModelAndView("signup-form");
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public @ResponseBody
	Object saveSignUpForm(HttpServletRequest request, @RequestBody User user) {
		Map<String, Object> model = new HashMap<String, Object>();
		manager.saveObject(user);
		UserInfo info = new UserInfo();
		info.setUserId(user.getId());
		manager.saveObject(info);
		if (user.getId() > 0) {
			model.put("success", true);
			utils.postAuditLog(request, "user_signup", "User with username :"
					+ user.getUserName() + " signed up successfully",
					user.getId());
		} else {
			model.put("success", false);
		}
		return model;

	}
}
