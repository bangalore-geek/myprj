/*
 * Created on Dec 7, 2004
 */
package com.defysope.dao;

import java.io.Serializable;
import java.util.List;

public interface DAO {

	public <T> List<T> getObjects(Class<T> clazz);

	public <T> T getObject(Class<T> clazz, Serializable id);

	public void saveObject(Object o);

	public void removeObject(Class clazz, Serializable id);

	public <T> List<T> getObjects(Class<T> clazz, String orderByField);

	public <T> T getObjectOrNull(Class<T> clazz, Serializable id);

	public boolean validateColumnName(String column);

}