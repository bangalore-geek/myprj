package com.defysope.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.defysope.model.Trainee;
import com.defysope.model.User;
import com.defysope.service.ApplicationUtils;
import com.defysope.service.PublicManager;

@Controller
public class TraineeController {

	@Autowired
	private PublicManager manager;

	@Autowired
	private ApplicationUtils utils;


	@RequestMapping(value = "/save-trainee", method = RequestMethod.POST)
	@Secured("ROLE_DF_HOME_PAGE")
	@ResponseBody
	public Object updateAssesement(HttpServletRequest request,
			@RequestBody Trainee trainee) {
		System.out.println("comec>>>>>>> ");
		User user = utils.getLoggedInUser();
		manager.saveObject(trainee);

		Map<String, Object> model = new HashMap<String, Object>();
		/*
		 * model.put("newCourseId", assesmentMaster.getId());
		 * model.put("success", true);
		 */
		return model;
	}
}
