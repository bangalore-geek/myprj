package com.defysope.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.defysope.dao.DAO;

@Repository
public class BaseDaoImpl implements DAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getObjects(Class<T> clazz) {
		return sessionFactory.getCurrentSession().createCriteria(clazz).list();
	}

	@SuppressWarnings("unchecked")
	public <T> T getObject(Class<T> clazz, Serializable id) {
		return (T) sessionFactory.getCurrentSession().load(clazz, id);
	}

	public void saveObject(Object o) {
		sessionFactory.getCurrentSession().saveOrUpdate(o);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see folklore.dao.DAO#removeObject(java.lang.Class, java.io.Serializable)
	 */
	@SuppressWarnings("rawtypes")
	public void removeObject(Class clazz, Serializable id) {
		sessionFactory.getCurrentSession().delete(
				sessionFactory.getCurrentSession().load(clazz, id));
	}

	@SuppressWarnings("unchecked")
	public <T> T getObjectOrNull(Class<T> clazz, Serializable id) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	@Override
	public <T> List<T> getObjects(Class<T> clazz, String orderByField) {
		return null;
	}

	@Override
	public boolean validateColumnName(String column) {
		// TODO Auto-generated method stub
		return false;
	}

}
