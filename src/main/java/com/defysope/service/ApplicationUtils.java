package com.defysope.service;


import javax.servlet.http.HttpServletRequest;

import com.defysope.dao.Page;
import com.defysope.model.User;

public interface ApplicationUtils {

	public User getLoggedInUser();

	public void postAuditLog(HttpServletRequest request, String categoryCode,
			String description, Integer affectedUserId);

	/*public List<Bookmark> getBookmarkList(Integer userId);*/

	public Page getBookarkList(int page, int rows);
	
	public String encryptPassword(String password);

}
