package com.defysope.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.defysope.dao.DashboardDao;
import com.defysope.model.User;
import com.defysope.model.dashboard.DashboardItem;
import com.defysope.model.dashboard.DashboardView;
import com.defysope.service.DashboardManager;

@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class DashboardManagerImpl extends BaseManager implements
		DashboardManager {

	@Autowired
	private DashboardDao dashboardDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<DashboardView> getViewableItems(User user, String type) {
		List<DashboardView> items = dashboardDao.getViews(user, type);
		return items;
	}

	public DashboardItem getItem(User user, String type, String name) {
		DashboardItem item = dashboardDao.getItem(type, name);
		return item;
	}

	@Override
	public DashboardView getView(User user, int id) {
		DashboardView view = dashboardDao.getObjectOrNull(DashboardView.class,
				id);
		if (view == null) {
			return null;
		}
		return view;
	}

	@Override
	public List<DashboardItem> getItems(User user, String type) {
		List<DashboardItem> items = dashboardDao.getItems(type);
		return items;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public DashboardView updateView(User user, int viewId, int row, int column,
			int height, boolean isNewRow, int deleteRow) throws Exception {
		DashboardView view = getView(user, viewId);

		if (view == null) {
			throw new Exception("Unable to find the requested resource.");
		}

		if (deleteRow > -1) {
			dashboardDao.deleteRow(user, view.getType().getName(), deleteRow,
					view.getId());
		}

		if (isNewRow) {
			dashboardDao.moveRowAtAndAfter(user, view.getType().getName(), row,
					1, view.getId());
		}

		view.setColumn(column);
		view.setRow(row);
		view.setHeight(height);
		saveObject(view);

		return view;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteRow(User user, String type, int row, int ignoreView) {
		dashboardDao.deleteRow(user, type, row, ignoreView);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void moveRowAtAndAfter(User user, String type, int row,
			int positions, int ignoreView) {
		dashboardDao.moveRowAtAndAfter(user, type, row, positions, ignoreView);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void addView(User user, DashboardView view, boolean newRow) {
		saveObject(view);
		if (newRow) {
			moveRowAtAndAfter(user, view.getType().getName(), view.getRow(), 1,
					view.getId());
		}
	}

}
