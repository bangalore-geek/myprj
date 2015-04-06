package com.defysope.dao;

import java.util.List;

import com.defysope.model.Bookmark;
import com.defysope.model.User;

public interface BookmarkUtilsDao {

	public User getLoggedInUser();

	public List<Bookmark> getBookmarkList(Integer userId);
	
	public Page getBookarkList(int page, int rows);
}
