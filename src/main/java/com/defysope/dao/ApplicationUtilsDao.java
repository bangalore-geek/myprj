package com.defysope.dao;

import com.defysope.model.AuditLogCategory;
import com.defysope.model.User;

public interface ApplicationUtilsDao {

	public User getLoggedInUser();

	/*public List<Bookmark> getBookmarkList(Integer userId);*/

	public Page getBookarkList(int page, int rows);

	public AuditLogCategory getAuditLogCategory(String categoryCode);
}
