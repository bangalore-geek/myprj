/*
 * Created on Dec 7, 2004
 */
package com.defysope.service.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;

import com.defysope.dao.DAO;
import com.defysope.service.Manager;

/**
 * Base class for Business Services - use this class for utility methods and
 * generic CRUD methods.
 * 
 * <p>
 * <a href="BaseManager.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class BaseManager implements Manager {
	protected final Log log = LogFactory.getLog(getClass());
	protected DAO dao = null;

	public BaseManager() {
	}

	public BaseManager(DAO dao) {
		this.dao = dao;
	}

	public void setDAO(DAO dao) {
		this.dao = dao;
	}

	public <T> T getObject(Class<T> clazz, Serializable id) {
		return dao.getObject(clazz, id);
	}

	public <T> List<T> getObjects(Class<T> clazz) {
		return dao.getObjects(clazz);
	}

	public void removeObject(Class clazz, Serializable id) {
		dao.removeObject(clazz, id);
	}

	public void saveObject(Object o) {
		dao.saveObject(o);
	}

	public String getParameter(Map parameters, String key) {
		String s = "";
		if (parameters.containsKey(key.toLowerCase())) {
			s = StringEscapeUtils.escapeHtml((String) parameters.get(key
					.toLowerCase()));
		}
		return s;
	}

	public int getParameterInt(Map parameters, String key) {
		return NumberUtils.toInt(getParameter(parameters, key));
	}

	public boolean getParameterBoolean(Map parameters, String key) {
		return BooleanUtils.toBoolean(getParameter(parameters, key));
	}

	/**
	 * Generic method used to get a all objects of a particular type.
	 * 
	 * @param clazz
	 *            The type of Objects to load
	 * @param orderByField
	 *            The field in which the list has to sort
	 * @return List of populated objects
	 */
	public <T> List<T> getObjects(Class<T> clazz, String orderByField) {
		return dao.getObjects(clazz, orderByField);
	}

	public <T> T getObjectOrNull(Class<T> clazz, Serializable id) {
		return dao.getObjectOrNull(clazz, id);
	}

	protected String getSchemaName(JdbcTemplate template) {
		String schemaName = (String) template.execute(new ConnectionCallback() {
			public Object doInConnection(Connection conn) throws SQLException,
					DataAccessException {
				return conn.getMetaData().getUserName();
			}
		});
		return schemaName;
	}

}
