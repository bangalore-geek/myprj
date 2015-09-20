package com.defysope.controller.kv;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.defysope.model.kv.Course;
import com.defysope.navigation.Menu;
import com.defysope.service.ApplicationUtils;
import com.defysope.service.AssesmentService;
import com.defysope.service.PublicManager;
import com.defysope.service.impl.Navigation;

@Controller
public class KvListController {
	
	@Autowired
	private ApplicationUtils utils;
	
	@Autowired
	private Navigation navigation;
	
	@Autowired
	private AssesmentService assesmentService;
	
	@Autowired
	private PublicManager manager;
	
	/* ===================== Courses ========================*/
	@Menu(title = "Course List", url = "/kv/courses", accessCode = "ROLE_DF_CONFIGURE_ASSESSMENT_COURSE", order = 1, visible = true)
	@RequestMapping(value = "/kv/courses", method = RequestMethod.GET)
	@Secured("ROLE_DF_CONFIGURE_ASSESSMENT")
	public ModelAndView courseListFtl(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("/kv/course-list", model);
	}
	
	@RequestMapping(value = "/kv/load-courses", method = RequestMethod.GET)
	@Secured("ROLE_DF_CONFIGURE_ASSESSMENT")
	@ResponseBody
	public Object loadCourses(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Course> assesmentCourses = assesmentService.getAssesmentMaster(); 
		model.put("viewAssesmentList",assesmentCourses );
		return model;
	}
	
	@RequestMapping(value = "/kv/edit/course-active", method = RequestMethod.POST)
	@Secured("ROLE_DF_CONFIGURE_ASSESSMENT")
	@ResponseBody
	public Object updateData(HttpServletRequest request, @RequestBody Course assesmentMaster) {
		boolean active = assesmentMaster.isActive();
		assesmentMaster.setActive(!active);
		manager.saveObject(assesmentMaster);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("success", true); 
		return model;
	} 

	/* ===================== Training list ========================*/
	@Menu(title = "Training List", url = "/kv/trainings?courseIdFilter=0", accessCode = "ROLE_DF_CONFIGURE_ASSESSMENT_TRAINING", order = 1, visible = true)
	@RequestMapping(value = "/kv/trainings", method = RequestMethod.GET)
	@Secured("ROLE_DF_CONFIGURE_ASSESSMENT_TRAINING")
	public ModelAndView trainingListFtl(HttpServletRequest request, @RequestParam Integer courseIdFilter) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("courseId", courseIdFilter);
		HttpSession session = request.getSession();
		session.setAttribute("courseIdFilter", courseIdFilter);
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("/kv/training-list", model);
	}
	
	@RequestMapping(value = "/kv/load-tranings", method = RequestMethod.GET)
	@Secured("ROLE_DF_CONFIGURE_ASSESSMENT_TRAINING")
	@ResponseBody
	public Object loadTrainings(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int courseIdFilter = (int) session.getAttribute("courseIdFilter");
		model.put("trainingList", assesmentService.getAssesmentCourses(courseIdFilter));
		return model;
	}
	
	/* ===================== Manage Assessment list ========================*/
	@Menu(title = "Assessment List", url = "/kv/assesments", accessCode = "ROLE_DF_MANAGE_ASSESSMENT", order = 1, visible = true)
	@RequestMapping(value = "/kv/assesments", method = RequestMethod.GET)
	@Secured("ROLE_DF_MANAGE_ASSESSMENT")
	public ModelAndView assessmentListFtl(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("/kv/assessment-list", model);
	}
	
	@RequestMapping(value = "/kv/load-assesments", method = RequestMethod.GET)
	@Secured("ROLE_DF_MANAGE_ASSESSMENT")
	@ResponseBody
	public Object loadData(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("trainingList", assesmentService.getAssesmentForOrganization(1));
		return model;
	}
	
	/* =================Impoter list============================*/
	@Menu(title = "Impoter List", url = "/kv/importer", accessCode = "ROLE_DF_IMPOTER", order = 1, visible = true)
	@RequestMapping(value = "/kv/importer", method = RequestMethod.GET)
	@Secured("ROLE_DF_IMPOTER")
	public ModelAndView excelImpoterListFtl(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("importer-list", model);
	}
	
	/* =================Training Attendance============================*/
	@Menu(title = "Training Attendance", url = "/kv/training-attendance", accessCode = "ROLE_DF_TRAINING_ATTENDANCE", order = 1, visible = true)
	@RequestMapping(value = "/kv/training-attendance", method = RequestMethod.GET)
	@Secured("ROLE_DF_TRAINING_ATTENDANCE")
	public ModelAndView trainingAttandanceFtl(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		return new ModelAndView("/kv/training-attendance", model);
	}
}