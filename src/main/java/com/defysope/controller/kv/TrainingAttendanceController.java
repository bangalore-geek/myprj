package com.defysope.controller.kv;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.defysope.service.ApplicationUtils;
import com.defysope.service.AssesmentService;
import com.defysope.service.impl.Navigation;

@Controller
public class TrainingAttendanceController {

	@Autowired
	private ApplicationUtils utils;

	@Autowired
	private Navigation navigation;

	@Autowired
	private AssesmentService assesmentService;

	@RequestMapping(value = "/load-course", method = RequestMethod.GET)
	@Secured("ROLE_DF_TRAINING_ATTENDANCE")
	@ResponseBody
	public Object loadCourse(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("courseList", assesmentService.getCoursesForCompany(utils.getLoggedInUser().getComId()));
		return model;
	}

	@RequestMapping(value = "/load-training-for-course", method = RequestMethod.GET)
	@Secured("ROLE_DF_TRAINING_ATTENDANCE")
	@ResponseBody
	public Object loadTraining(HttpServletRequest request,
			@RequestParam int courseId) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("trainingList",
				assesmentService.getTrainings(utils.getLoggedInUser().getComId(), courseId));
		return model;
	}
}
