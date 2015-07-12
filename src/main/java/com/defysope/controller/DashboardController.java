package com.defysope.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.BooleanUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.defysope.model.User;
import com.defysope.model.dashboard.DashboardItem;
import com.defysope.model.dashboard.DashboardType;
import com.defysope.model.dashboard.DashboardView;
import com.defysope.providers.DashboardViewContext;
import com.defysope.providers.DashboardViewProvider;
import com.defysope.service.ApplicationUtils;
import com.defysope.service.DashboardManager;
import com.defysope.utils.NumberUtils;


public class DashboardController {

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

	@RequestMapping("/v2/dashboard/dashlet-views/load")
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

	@RequestMapping("/v2/dashboard/dashlet-view/view")
	@Secured("ROLE_HOME_TAB")
	public ModelAndView viewDashletView(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("view") int viewId) {

		DashboardView view = dashboardManager.getObjectOrNull(
				DashboardView.class, viewId);
		/*
		 * if (view == null) { throw new
		 * Exception("Unable to find the requested resource."); }
		 */

		User user = utils.getLoggedInUser();
		DashboardItem item = view.getItem();
		/*
		 * if (item == null || !user.hasRightToFeature(item.getFeatureCode())) {
		 * throw new AccessDeniedException(
		 * "Access to the specified resource is denied."); }
		 */

		DashboardViewProvider provider = getViewProvider(item);
		/*
		 * if (provider == null) { throw new ResourceNotFoundException(
		 * "Unable to find the requested resource."); }
		 */

		int height = NumberUtils.toInt(request.getParameter("height"));
		if (height != 0 && height >= view.getItem().getHeight()) {
			view.setHeight(height);
			dashboardManager.saveObject(view);
		}

		DashboardViewContext context = new DashboardViewContext(user, view,
				request);
		return provider.getModelAndView(context);
	}

	private DashboardViewProvider getViewProvider(DashboardItem item) {

		DashboardViewProvider provider = viewProviderMap.get(item.getName());
		if (provider == null) {
			synchronized (this) {
				if (provider == null) {
					Map<String, DashboardViewProvider> viewProviders = getViewProviders();
					for (DashboardViewProvider pv : viewProviders.values()) {
						if (pv.supports(item.getName())) {
							provider = pv;
							break;
						}
					}
					viewProviderMap.put(item.getName(), provider);
				}
			}
		}

		return provider;
	}

	private Map<String, DashboardViewProvider> getViewProviders() {
		if (viewProviders == null) {
			synchronized (this) {
				if (viewProviders == null) {
					viewProviders = applicationContext
							.getBeansOfType(DashboardViewProvider.class);
				}
			}
		}
		return viewProviders;
	}

	@RequestMapping("/v2/dashboard/dashlet-view/update")
	@Secured("ROLE_HOME_TAB")
	@ResponseBody
	public Object saveDashletView(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("view") int viewId,
			@RequestParam int row, @RequestParam int column,
			@RequestParam int height) {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			User user = utils.getLoggedInUser();
			log.info("Updating dashlet {} to row {} column {} for user {}.",
					new Object[] { viewId, row, column, user.getUserName() });

			DashboardView view = dashboardManager.getView(user, viewId);

			dashboardManager.updateView(user, viewId, row, column, height,
					BooleanUtils.toBoolean(request.getParameter("newRow")),
					NumberUtils.toInt(request.getParameter("deleteRow"), -1));

			model.put("success", true);
		} catch (RuntimeException e) {
			log.error(e.toString(), e);

		} catch (Exception e) {
			log.error(e.toString(), e);
		}
		return model;
	}

	@RequestMapping(value = "/v2/dashboard/dashlet-view/add", method = RequestMethod.GET)
	@Secured("ROLE_HOME_TAB")
	public ModelAndView addDashlet(HttpServletRequest request,
			HttpServletResponse response, @RequestParam String type) {
		User user = utils.getLoggedInUser();
		Map<String, Object> model = new HashMap<String, Object>();
		List<DashboardItem> items = dashboardManager.getItems(user, type);
		model.put("items", items);
		return new ModelAndView("WEB-INF/freemarker/dashboard/add", model);
	}

	@RequestMapping(value = "/v2/dashboard/dashlet-view/add", method = RequestMethod.POST)
	@Secured("ROLE_HOME_TAB")
	@ResponseBody
	public Object addDashletView(HttpServletRequest request,
			HttpServletResponse response, @RequestParam String type,
			@RequestParam String item, @RequestParam int row,
			@RequestParam int column, @RequestParam boolean newRow) {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			User user = utils.getLoggedInUser();
			log.info("Creating view {} at row {} column {} for user {}.",
					new Object[] { item, row, column, user.getUserName() });

			DashboardView view = new DashboardView();
			view.setUserId(user == null ? 0 : user.getId());
			view.setItem(dashboardManager.getItem(user, type, item));
			view.setType(dashboardManager.getObjectOrNull(DashboardType.class,
					type));

			view.setColumn(column);
			view.setRow(row);
			view.setHeight(NumberUtils.toInt(request.getParameter("height")));
			dashboardManager.addView(user, view, newRow);

			DashboardItem dashletItem = view.getItem();
			model.put("success", true);
			model.put("view", view);
		} catch (RuntimeException e) {
			log.error(e.toString(), e);
		} catch (Exception e) {
			log.error(e.toString(), e);
		}
		return model;
	}

	@RequestMapping("/v2/dashboard/dashlet-view/delete")
	@Secured("ROLE_HOME_TAB")
	@ResponseBody
	public Object deleteDashletView(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("view") int viewId) {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			User user = utils.getLoggedInUser();
			log.info("Deleting dashlet {} for user {}.", new Object[] { viewId,
					user.getUserName() });
			DashboardView view = dashboardManager.getObjectOrNull(
					DashboardView.class, viewId);
			if (view != null) {
				dashboardManager
						.removeObject(DashboardView.class, view.getId());

				int deleteRow = NumberUtils.toInt(
						request.getParameter("deleteRow"), -1);
				if (deleteRow != -1) {
					dashboardManager.deleteRow(user, view.getType().getName(),
							deleteRow, -1);
				}
			}

			model.put("success", true);
		} catch (RuntimeException e) {
			log.error(e.toString(), e);
		} catch (Exception e) {
			log.error(e.toString(), e);
		}
		return model;
	}

	@RequestMapping(value = "/v2/dashboard/dashlet-view/options", method = RequestMethod.GET)
	@Secured("ROLE_HOME_TAB")
	public ModelAndView dashletOptions(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("view") int viewId) {
		User user = utils.getLoggedInUser();

		DashboardView view = dashboardManager.getView(user, viewId);
		/*
		 * if (view == null || !view.getItem().isOptionsEnabled()) { throw new
		 * ResourceNotFoundException( "Unable to find the requested resource.");
		 * }
		 */

		DashboardViewProvider provider = getViewProvider(view.getItem());
		/*
		 * if (provider == null) { throw new ResourceNotFoundException(
		 * "Unable to find the requested resource."); }
		 * 
		 * saveStats(user, "dashlet-option-view", view.getItem().getName(),
		 * "Viewed dashlet options for " + view.getItem().getCaption() + ".");
		 */
		DashboardViewContext context = new DashboardViewContext(user, view,
				request);
		return provider.getOptionModelAndView(context);
	}

	@RequestMapping(value = "/v2/dashboard/dashlet-view/options", method = RequestMethod.POST)
	@Secured("ROLE_HOME_TAB")
	@ResponseBody
	public Object dashletOptionsSave(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("view") int viewId) {
		Map<String, Object> model = new HashMap<String, Object>();

		try {
			User user = utils.getLoggedInUser();

			DashboardView view = dashboardManager.getView(user, viewId);
			/*
			 * if (view == null || !view.getItem().isOptionsEnabled()) { throw
			 * new ResourceNotFoundException(
			 * "Unable to find the requested resource."); }
			 */

			Map<String, String> params = new HashMap<String, String>();
			@SuppressWarnings("unchecked")
			Map<String, String[]> parameterMap = request.getParameterMap();
			for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
				String[] value = entry.getValue();
				params.put(entry.getKey(),
						value != null && value.length > 0 ? value[0] : null);
			}

			view.setOptions(JSONObject.fromObject(params).toString());
			dashboardManager.saveObject(view);

			/*
			 * saveStats(user, "dashlet-option", view.getItem().getName(),
			 * "Saved dashlet options for " + view.getItem().getCaption() +
			 * ".");
			 */

			model.put("success", true);
		} catch (RuntimeException e) {
			log.error(e.toString(), e);
		} catch (Exception e) {
			log.error(e.toString(), e);
		}

		return model;
	}

}
