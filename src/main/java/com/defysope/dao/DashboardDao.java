package com.defysope.dao;

import java.util.List;

import com.defysope.model.User;
import com.defysope.model.dashboard.DashboardItem;
import com.defysope.model.dashboard.DashboardView;

public interface DashboardDao extends DAO {

	List<DashboardView> getViews(User user, String type);

	DashboardItem getItem(String type, String name);

	DashboardView getView(User user, String type, String name);

	List<DashboardItem> getItems(String type);

	void moveRowAtAndAfter(User user, String type, int row, int positions, int ignoreView);

	List<DashboardView> getViews(User user, String type, int row);

	void deleteRow(User user, String type, int row, int ignoreView);

}
