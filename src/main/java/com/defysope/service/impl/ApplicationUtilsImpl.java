package com.defysope.service.impl;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.defysope.dao.ApplicationUtilsDao;
import com.defysope.dao.Page;
import com.defysope.model.AuditLogCategory;
import com.defysope.model.AuditLogEntry;
import com.defysope.model.User;
import com.defysope.service.ApplicationUtils;
import com.defysope.service.PublicManager;

@Service
@Transactional(readOnly = true)
public class ApplicationUtilsImpl implements ApplicationUtils {

	@Autowired
	private ApplicationUtilsDao dao;

	@Autowired
	private PublicManager publicManager;

	@Override
	public User getLoggedInUser() {
		return dao.getLoggedInUser();
	}

/*	@Override
	public List<Bookmark> getBookmarkList(Integer userId) {
		return dao.getBookmarkList(userId);
	}*/

	@Override
	public Page getBookarkList(int page, int rows) {
		return dao.getBookarkList(page, rows);
	}

	@Override
	@Transactional(readOnly = false)
	public void postAuditLog(HttpServletRequest request, String categoryCode,
			String description, Integer affectedUserId) {
		User user = dao.getLoggedInUser();
		saveAuditLogEntry(categoryCode, user, request.getRemoteAddr(),
				description, affectedUserId);
	}

	@Transactional(readOnly = false)
	private void saveAuditLogEntry(String categoryCode, User user,
			String remoteAddr, String description, Integer affectedUserId) {
		AuditLogEntry entry = new AuditLogEntry(user, remoteAddr, description,
				affectedUserId);
		entry.setAuditCategory(getAuditLogId(categoryCode));
		publicManager.saveObject(entry);

	}

	private int getAuditLogId(String categoryCode) {

		AuditLogCategory auditLogCategory = dao
				.getAuditLogCategory(categoryCode);
		if (auditLogCategory == null) {
			auditLogCategory = new AuditLogCategory();
			auditLogCategory.setCode(categoryCode);
			auditLogCategory.setDescription(categoryCode);
			publicManager.saveObject(auditLogCategory);
		}
		return auditLogCategory != null ? auditLogCategory.getId() : 0;
	}

	@Override
	public String encryptPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
	}
}
