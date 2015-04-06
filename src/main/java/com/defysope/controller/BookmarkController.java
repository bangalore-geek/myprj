package com.defysope.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.defysope.dao.Page;
import com.defysope.model.Attachment;
import com.defysope.model.Bookmark;
import com.defysope.model.User;
import com.defysope.service.BookmarkUtils;
import com.defysope.service.PublicManager;
import com.defysope.utils.logging.Log;

@Controller
public class BookmarkController {

	@Log
	Logger logger;

	@Autowired
	private PublicManager manager;

	@Autowired
	private BookmarkUtils bookmarkUtils;

	@RequestMapping(value = "/bookmark", method = RequestMethod.GET)
	@Secured("ROLE_PG_HOME")
	public ModelAndView getBookmarkListPage(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		User user = bookmarkUtils.getLoggedInUser();
		logger.debug("Logged in user {} ", user.getUserName());
		Page page = bookmarkUtils.getBookarkList(0, 15);
		page.getTotalNumberOfElements();
		page.getPageSize();
		page.getThisPageElements();
		model.put("bookmarkList", bookmarkUtils.getBookmarkList(user.getId()));
		return new ModelAndView("bookmarklist", model);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@Secured("ROLE_PG_HOME")
	@ResponseBody
	public Object save(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute Bookmark bookmark,
			@ModelAttribute Attachment file) throws IOException {
		Map<String, Object> model = new HashMap<String, Object>();
		bookmark.setUserId(bookmarkUtils.getLoggedInUser().getId());
		bookmark.setModifiedDate(new Date());
		bookmark.setPostedDate(new Date());
		if (file.getFile().getOriginalFilename() != ""
				&& file.getFile().getOriginalFilename() != null) {
			bookmark.setFileName(file.getFile().getOriginalFilename());
			bookmark.setImage(file.getFile().getBytes());
		}
		manager.saveObject(bookmark);
		model.put("success", true);
		return model;
	}

}
