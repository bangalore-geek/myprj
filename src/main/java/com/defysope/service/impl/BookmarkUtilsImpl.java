package com.defysope.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.defysope.dao.BookmarkUtilsDao;
import com.defysope.dao.Page;
import com.defysope.model.Bookmark;
import com.defysope.model.User;
import com.defysope.service.BookmarkUtils;

@Service
@Transactional(readOnly = true)
public class BookmarkUtilsImpl implements BookmarkUtils {

	@Autowired
	private BookmarkUtilsDao dao;

	@Override
	public User getLoggedInUser() {
		return dao.getLoggedInUser();
	}

	@Override
	public List<Bookmark> getBookmarkList(Integer userId) {
		return dao.getBookmarkList(userId);
	}

	@Override
	public Page getBookarkList(int page, int rows) {
		return dao.getBookarkList(page, rows);
	}
}
