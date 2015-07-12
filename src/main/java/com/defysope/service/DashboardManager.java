package com.defysope.service;

import java.util.List;
import com.defysope.model.User;
import com.defysope.model.dashboard.DashboardItem;
import com.defysope.model.dashboard.DashboardView;

public interface DashboardManager extends Manager {

	List<DashboardView> getViewableItems(User user, String type);

	DashboardView getView(User user, int id);

	DashboardItem getItem(User user, String type, String name);

	List<DashboardItem> getItems(User user, String type);

	DashboardView updateView(User user, int view, int row, int column,
			int height, boolean isNewRow, int deleteRow) throws Exception;

	void deleteRow(User user, String type, int row, int ignoreView);

	void moveRowAtAndAfter(User user, String type, int row, int positions,
			int ignoreView);

	void addView(User user, DashboardView view, boolean newRow);

}
