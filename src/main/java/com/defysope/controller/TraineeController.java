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

}
