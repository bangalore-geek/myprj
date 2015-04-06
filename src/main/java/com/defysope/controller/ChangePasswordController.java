package com.defysope.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChangePasswordController {
	
	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	@Secured("ROLE_PG_HOME")
	public ModelAndView getBookmarkListPage(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> model = new HashMap<String,Object>();
		return new ModelAndView("changepassword",model);
	}

}
