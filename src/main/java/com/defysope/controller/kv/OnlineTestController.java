package com.defysope.controller.kv;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.defysope.model.User;
import com.defysope.model.kv.Course;
import com.defysope.model.kv.Trainee;
import com.defysope.model.kv.Training;
import com.defysope.navigation.Menu;
import com.defysope.service.ApplicationUtils;
import com.defysope.service.AssesmentService;
import com.defysope.service.PublicManager;
import com.defysope.service.impl.Navigation;

@Controller
public class OnlineTestController {
	
	@Autowired
	private ApplicationUtils utils;
	
	@Autowired
	private AssesmentService assesmentService;
	
	@Autowired
	private Navigation navigation;
	
	@Autowired
	private PublicManager manager;
	
	@Menu(title = "Course List", url = "/corpyogi/kv/test", accessCode = "ROLE_DF_CREATE_ROLE", order = 1, visible = true)
	@RequestMapping(value = "/corpyogi/kv/test", method = RequestMethod.GET)
	@Secured("ROLE_DF_HOME_PAGE")
	public ModelAndView createRole(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("/kv/test-wizard", model); 
	}
	
	@RequestMapping(value = "/kv/load-test-details", method = RequestMethod.GET)
	@Secured("ROLE_DF_HOME_PAGE")
	@ResponseBody
	public Object loadData(HttpServletRequest request) {
		User user = utils.getLoggedInUser();
		Map<String, Object> model = new HashMap<String, Object>();

		Trainee trainee =  assesmentService.getTraineeByUserId(user.getId());
		Course course =  manager.getObjectOrNull(Course.class, trainee.getCourseId());
		Training training = manager.getObjectOrNull(Training.class, trainee.getCourseId());
		
		model.put("course", course);
		model.put("training", training);
		return model;
	}
	
	@RequestMapping(value = "/kv/load-question", method = RequestMethod.GET)
	@Secured("ROLE_DF_HOME_PAGE")
	@ResponseBody
	public Object loadQuestions(HttpServletRequest request) {
		// http://stackoverflow.com/questions/8674718/best-way-to-select-random-rows-postgresql -- sample link
		List<Map<String, Object>> questionList = assesmentService.getQuestion();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("questionList", questionList);
		return model;
	}
}
