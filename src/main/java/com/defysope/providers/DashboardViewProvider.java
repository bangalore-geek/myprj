package com.defysope.providers;

import org.springframework.web.servlet.ModelAndView;

public interface DashboardViewProvider {

	String DASHLET_TITLE = "_dashlet_title";
	String DASHLET_HELP_TITLE= "_dashlet_help_title";
	String DASHLET_HELP_CONTENT= "_dashlet_help_content";

	boolean supports(String name);

	ModelAndView getModelAndView(DashboardViewContext context);

	ModelAndView getOptionModelAndView(DashboardViewContext context);
}
