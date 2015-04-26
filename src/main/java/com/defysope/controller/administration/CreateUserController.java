package com.defysope.controller.administration;

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
import com.defysope.service.impl.Navigation;

@Controller
public class CreateUserController {

	@Autowired
	private ApplicationUtils utils;

	@Autowired
	private Navigation navigation;

	@Menu(title = "Create New User", url = "/create-user", accessCode = "ROLE_DF_CREATE_USER", order = 1, visible = true)
	@RequestMapping(value = "/create-user", method = RequestMethod.GET)
	@Secured("ROLE_DF_CREATE_USER")
	public ModelAndView createUser(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("create-user", model);
	}

}
