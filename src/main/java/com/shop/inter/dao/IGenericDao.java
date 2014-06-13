package com.shop.inter.dao;

import java.util.List;

public interface IGenericDao<T> {
	/**
	 * Save new value.
	 * 
	 * @param item
	 *            Item.	 * 
	 */
	void save(T item);

	/**
	 * Update existing item.
	 * 
	 * @param item
	 *            Item.
	 * @return true if saved successfully, false otherwise.
	 */
	T update(T item);

	/**
	 * Get existing object by its id.
	 * 
	 * @param objectId
	 *            Id of object.
	 * @return Object is returned; null, if not found.
	 */
	T findById(Class<T> objectClass, Long id);

	/**
	 * Get all objects from table.
	 * 
	 * @return List of objects.
	 */
	List<T> findAll(Class<T> objectClass);

	/**
	 * Delete existing item.
	 * 
	 * @param item
	 *            Item.	
	 */
	void delete(T item);

	/**
	 * 
	 * @param singleQuery
	 * @param params
	 * @return entity
	 */
	T findEntity(String singleQuery, Object... params);

	/**
	 * 
	 * @param find list etity
	 * @param params
	 * @return list entity
	 */
	List<T> findEntityList(String singleQuery, Object... params);
}
