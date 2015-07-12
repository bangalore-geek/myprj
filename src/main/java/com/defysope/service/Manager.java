/*
 * Created on Dec 7, 2004
 */
package com.defysope.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.defysope.dao.DAO;

public interface Manager {

	public static final String TRANSACTION_MANAGER = "transactionManager";

	public static final String PUBLIC_TRANSACTION_MANAGER = "publicTransactionManager";

	/**
	 * Expose the setDAO method for testing purposes
	 * 
	 * @param dao
	 */
	public void setDAO(DAO dao);

	/**
	 * Generic method used to get a all objects of a particular type.
	 * 
	 * @param clazz
	 *            the type of objects
	 * @return List of populated objects
	 */
	public <T> List<T> getObjects(Class<T> clazz);

	/**
	 * Generic method to get an object based on class and identifier.
	 * 
	 * @param clazz
	 *            model class to lookup
	 * @param id
	 *            the identifier (primary key) of the class
	 * @return a populated object
	 * @see org.springframework.orm.ObjectRetrievalFailureException
	 */
	public <T> T getObject(Class<T> clazz, Serializable id);

	/**
	 * Generic method to save an object.
	 * 
	 * @param o
	 *            the object to save
	 */
	public void saveObject(Object o);

	/**
	 * Generic method to delete an object based on class and id
	 * 
	 * @param clazz
	 *            model class to lookup
	 * @param id
	 *            the identifier of the class
	 */
	public void removeObject(Class clazz, Serializable id);

	/**
	 * Generic method used to get a all objects of a particular type.
	 * 
	 * @param clazz
	 *            The type of Objects to load
	 * @param orderByField
	 *            The field in which the list has to sort
	 * @return List of populated objects
	 */
	<T> List<T> getObjects(Class<T> clazz, String orderByField);

	/**
	 * Generic method used to get a all objects of a particular type.
	 * 
	 * @param clazz
	 *            The type of Objects to load
	 * @param id
	 *            Id of the object to find and return
	 * @return if the object is found that object is returned else null
	 */
	public <T> T getObjectOrNull(Class<T> clazz, Serializable id);

}
