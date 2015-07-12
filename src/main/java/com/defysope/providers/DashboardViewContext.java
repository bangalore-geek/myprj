package com.defysope.providers;

import javax.servlet.http.HttpServletRequest;

import com.defysope.model.User;
import com.defysope.model.dashboard.DashboardView;

public class DashboardViewContext {

	private User user;

	private DashboardView view;

	private HttpServletRequest request;

	public DashboardViewContext(User user, DashboardView view,
			HttpServletRequest request) {
		super();
		this.user = user;
		this.view = view;
		this.request = request;
	}

	public User getUser() {
		return user;
	}

	public DashboardView getView() {
		return view;
	}

	public HttpServletRequest getRequest() {
		return request;
	}
}
