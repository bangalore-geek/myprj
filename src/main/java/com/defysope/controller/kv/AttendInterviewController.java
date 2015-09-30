package com.defysope.controller.kv;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.defysope.model.kv.Company;
import com.defysope.model.kv.Trainee;
import com.defysope.navigation.Menu;
import com.defysope.service.ApplicationUtils;
import com.defysope.service.PublicManager;
import com.defysope.service.impl.Navigation;

@Controller
public class AttendInterviewController {

	@Autowired
	private ApplicationUtils utils;
	
	@Autowired
	private Navigation navigation;
	
	@Autowired
	private PublicManager manager;
	
	@Menu(title = "Schedule Interview", url = "/kv/schedule-interview", accessCode = "ROLE_DF_ATTEND_INTERVIEW", order = 4, visible = true)
	@RequestMapping(value = "/kv/schedule-interview", method = RequestMethod.GET)
	@Secured("ROLE_DF_ATTEND_INTERVIEW")
	public ModelAndView scheduleInterview(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("/kv/attend-interview", model); 
	}
	
	@Menu(title = "My Profile", url = "/kv/candidate/profile", accessCode = "ROLE_DF_ATTEND_INTERVIEW", order = 5, visible = true)
    @RequestMapping(value = "/kv/candidate/profile", method = RequestMethod.GET)
    @Secured("ROLE_DF_ATTEND_INTERVIEW")
    public ModelAndView candidateProfile(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
        return new ModelAndView("kv/candidate-profile", model);
    }
	
	@Menu(title = "Start Interview", url = "/kv/candidate/start-interview", accessCode = "ROLE_DF_ATTEND_INTERVIEW", order = 6, visible = true)
    @RequestMapping(value = "/kv/candidate/start-interview", method = RequestMethod.GET)
    @Secured("ROLE_DF_ATTEND_INTERVIEW")
    public ModelAndView takeInterview(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
        return new ModelAndView("kv/start-interview", model);
    }	
	
	@RequestMapping(value = "/kv/load-candidate", method = RequestMethod.GET)
	@Secured("ROLE_DF_ATTEND_INTERVIEW")
	@ResponseBody
	public Object loadCandidate(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("thisCandidate", utils.getLoggedInUser());
		return model;
	}
	
/*	@RequestMapping(value = "/kv/save-candidate-profile", method = RequestMethod.POST)
	@Secured("ROLE_DF_ATTEND_INTERVIEW")
	@ResponseBody
	public Object updateCAndidateProfile(HttpServletRequest request, @RequestBody Tr thisCompany) {
		manager.saveObject(thisCompany);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("success", true); 
		return model;
	} */
}
