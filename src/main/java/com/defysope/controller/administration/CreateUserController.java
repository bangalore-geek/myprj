package com.defysope.controller.administration;

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

import com.defysope.model.Role;
import com.defysope.model.User;
import com.defysope.navigation.Menu;
import com.defysope.service.ApplicationUtils;
import com.defysope.service.PublicManager;
import com.defysope.service.UserService;
import com.defysope.service.impl.Navigation;

@Controller
public class CreateUserController {

	@Autowired
	private ApplicationUtils utils;

	@Autowired
	private PublicManager publicManager;
	
	@Autowired
	private UserService userService;

	@Autowired
	private Navigation navigation;

	@Menu(title = "Create New User", url = "/corpyogi/administration/userinfo", accessCode = "ROLE_DF_CREATE_USER", order = 2, visible = true)
	@RequestMapping(value = "/corpyogi/administration/userinfo", method = RequestMethod.GET)
	@Secured("ROLE_DF_CREATE_USER")
	public ModelAndView createUser(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		//model.put("roleList", publicManager.getObjects(Role.class, "description"));
		return new ModelAndView("create-user", model);
	}

	@RequestMapping(value = "/corpyogi/administration/userinfo", method = RequestMethod.POST)
	@Secured("ROLE_DF_CREATE_USER")
	@ResponseBody
	public Object saveUser(@RequestBody User user) {
		Map<String, Object> model = new HashMap<>();
		publicManager.saveObject(user);
		model.put("user", user);
		return model;
	}
	
	@RequestMapping(value = "/load/user/role", method = RequestMethod.GET)
	@Secured("ROLE_DF_CREATE_USER")
	@ResponseBody
	public Object loadRoleList(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Role> list = publicManager.getObjects(Role.class, "description");
		model.put("roleLisdsadast", list);
		return model;
	}
}
