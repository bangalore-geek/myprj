package com.defysope.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import com.defysope.dao.ApplicationUtilsDao;
import com.defysope.dao.Page;
import com.defysope.dao.UserDAO;
import com.defysope.model.AuditLogCategory;
import com.defysope.model.User;

@Repository
public class ApplicationUtilsDaoImpl implements ApplicationUtilsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User getLoggedInUser() {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		org.springframework.security.core.userdetails.User authuser = (authentication != null && authentication
				.getPrincipal() instanceof org.springframework.security.core.userdetails.User) ? (org.springframework.security.core.userdetails.User) authentication
				.getPrincipal() : null;
		return authuser == null ? null : userDAO.getUser(authuser.getUsername());
	}

/*	@SuppressWarnings("unchecked")
	@Override
	public List<Bookmark> getBookmarkList(Integer userId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Bookmark.class);
		criteria.add(Restrictions.eq("userId", userId));
		criteria.add(Restrictions.eq("softDeleted", false));
		return criteria.list();
	}
*/
	@Override
	public Page getBookarkList(int page, int rows) {

		String sql = "select cid from tblbookmark";
		return JdbcPage.getJdbcPageInstance(jdbcTemplate, sql, page, rows,
				new RowMapper() {
					public Object mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("cid", rs.getInt("cid"));
						return map;
					}
				});

	}

	@Override
	public AuditLogCategory getAuditLogCategory(String categoryCode) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				AuditLogCategory.class);
		criteria.add(Restrictions.eq("code", categoryCode));
		return (AuditLogCategory) criteria.uniqueResult();
	}

}
