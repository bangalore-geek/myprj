package com.defysope.controller;

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
public class TestController {
	
	@Autowired
	private ApplicationUtils utils;

	@Autowired
	private Navigation navigation;

	@Menu(title = "Student Profile", url = "/student-profile", accessCode = "ROLE_DF_STUDENT_PROFILE", order = 1, visible = true)
	@RequestMapping(value = "/student-profile", method = RequestMethod.GET)
	@Secured("ROLE_DF_STUDENT_PROFILE")
	public ModelAndView a(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("home", model);
	}

	@Menu(title = "Search Job", url = "/search-job", accessCode = "ROLE_DF_SEARCH_JOB", order = 1, visible = true)
	@RequestMapping(value = "/search-job", method = RequestMethod.GET)
	@Secured("ROLE_DF_SEARCH_JOB")
	public ModelAndView b(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("home", model);
	}

	@Menu(title = "Search Training", url = "/search-training", accessCode = "ROLE_DF_SEARCH_TRAINING", order = 1, visible = true)
	@RequestMapping(value = "/search-training", method = RequestMethod.GET)
	@Secured("ROLE_DF_SEARCH_TRAINING")
	public ModelAndView c(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("home", model);
	}

	@Menu(title = "Freelancer Profile", url = "/freelancer-profile", accessCode = "ROLE_DF_FREELANCER_PROFILE", order = 1, visible = true)
	@RequestMapping(value = "/freelancer-profile", method = RequestMethod.GET)
	@Secured("ROLE_DF_FREELANCER_PROFILE")
	public ModelAndView d(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("home", model);
	}

	@Menu(title = "Become a Trainer", url = "/become-trainer", accessCode = "ROLE_DF_BECOME_TRAINER", order = 1, visible = true)
	@RequestMapping(value = "/become-trainer", method = RequestMethod.GET)
	@Secured("ROLE_DF_BECOME_TRAINER")
	public ModelAndView e(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("home", model);
	}

	@Menu(title = "Post a Job", url = "/post-job", accessCode = "ROLE_DF_POST_JOB", order = 1, visible = true)
	@RequestMapping(value = "/post-job", method = RequestMethod.GET)
	@Secured("ROLE_DF_POST_JOB")
	public ModelAndView f(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("home", model);
	}

	@Menu(title = "Search Candidate", url = "/search-candidate", accessCode = "ROLE_DF_SEARCH_CANDIDATE", order = 1, visible = true)
	@RequestMapping(value = "/search-candidate", method = RequestMethod.GET)
	@Secured("ROLE_DF_SEARCH_CANDIDATE")
	public ModelAndView g(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("home", model);
	}

	@Menu(title = "Company Profile", url = "/company-profile", accessCode = "ROLE_DF_COMPANY_PROFILE", order = 1, visible = true)
	@RequestMapping(value = "/company-profile", method = RequestMethod.GET)
	@Secured("ROLE_DF_COMPANY_PROFILE")
	public ModelAndView h(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("home", model);
	}

}
