package com.defysope.providers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.MessageSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.util.Assert;
import org.springframework.web.servlet.ModelAndView;

import com.defysope.model.dashboard.DashboardView;
import com.defysope.service.DashboardManager;
import com.defysope.utils.StringUtils;

public abstract class AbstractDashboardViewProvider extends JdbcDaoSupport
		implements DashboardViewProvider {

	private static final String SERVLET_CONTEXT = "contextPath";

	private String name;

	private String viewName;

	private String optionsViewName;

	protected DashboardManager dashboardManager;

	public AbstractDashboardViewProvider() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public void setOptionsViewName(String optionsViewName) {
		this.optionsViewName = optionsViewName;
	}

	public void setDashboardManager(DashboardManager dashboardManager) {
		this.dashboardManager = dashboardManager;
	}

	@Override
	public boolean supports(String name) {
		return StringUtils.equalsIgnoreCase(name, this.name);
	}

	@Override
	public ModelAndView getModelAndView(DashboardViewContext context) {
		DashboardView view = context.getView();

		Map<String, Object> model = new HashMap<String, Object>();
		model.put(DASHLET_TITLE, view.getItem().getCaption());
		model.put(SERVLET_CONTEXT, context.getRequest().getContextPath());

		String itemName = view.getItem().getName();
		Map<String, Object> dashletModel = getModel(context);
		Assert.notNull(dashletModel);

		model.putAll(dashletModel);

		model.put("_view", view);

		return new ModelAndView(viewName, model);
	}

	@Override
	public ModelAndView getOptionModelAndView(DashboardViewContext context) {
		Map<String, Object> model = getOptionsModel(context);
		Assert.notNull(model);

		DashboardView view = context.getView();
		model.put("_view", view);
		model.put(SERVLET_CONTEXT, context.getRequest().getContextPath());
		return new ModelAndView(optionsViewName, model);
	}

	protected String getNoDataMessge(DashboardViewContext context,
			Object... objects) {
		return "No record found!";
	}

	protected abstract Map<String, Object> getOptionsModel(
			DashboardViewContext context);

	protected abstract Map<String, Object> getModel(DashboardViewContext context);

}
