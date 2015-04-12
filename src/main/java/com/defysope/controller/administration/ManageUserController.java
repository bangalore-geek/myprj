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
public class ManageUserController {
	
	@Autowired
	private BookmarkUtils utils;

	@Menu(title = "Manage User", url = "/manage-user", accessCode = "ROLE_DF_MANAGE_USER", order = 1, visible = true)
	@RequestMapping(value = "/manage-user", method = RequestMethod.GET)
	@Secured("ROLE_PG_HOME")
	public ModelAndView manageUser(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("manage-user", model);
	}

}
