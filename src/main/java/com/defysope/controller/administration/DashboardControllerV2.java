package com.defysope.controller.administration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.defysope.controller.DashboardController;
import com.defysope.model.User;
import com.defysope.model.dashboard.DashboardView;
import com.defysope.providers.DashboardViewProvider;
import com.defysope.service.ApplicationUtils;
import com.defysope.service.DashboardManager;

public class DashboardControllerV2 {

	private static org.slf4j.Logger log = LoggerFactory
			.getLogger(DashboardController.class);

	@Autowired
	private DashboardManager dashboardManager;

	@Autowired
	private ApplicationUtils utils;

	@Autowired
	private ApplicationContext applicationContext;

	private Map<String, DashboardViewProvider> viewProviders;

	private Map<String, DashboardViewProvider> viewProviderMap = new HashMap<String, DashboardViewProvider>();

	@RequestMapping("/dashboard/views/load")
	@Secured("ROLE_HOME_TAB")
	@ResponseBody
	public Object loadDashletViews(HttpServletRequest request,
			HttpServletResponse response, @RequestParam String type) {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			User user = utils.getLoggedInUser();
			List<DashboardView> items = dashboardManager.getViewableItems(user,
					type);
			model.put("views", items);
			model.put("success", true);
		} catch (RuntimeException e) {
			log.error(e.toString(), e);
		} catch (Exception e) {
			log.error(e.toString(), e);

		}
		return model;
	}

}
