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
import com.defysope.service.BookmarkUtils;

@Controller
public class CreateRoleController {
	
	@Autowired
	private BookmarkUtils utils;

	@Menu(title = "Create New Role", url = "/create-role", accessCode = "ROLE_DF_CREATE_ROLE", order = 1, visible = true)
	@RequestMapping(value = "/create-role", method = RequestMethod.GET)
	@Secured("ROLE_DF_CREATE_ROLE")
	public ModelAndView createRole(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("create-role", model);
	}

}
