package com.shop.inter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class GenericDao<T> implements IGenericDao<T> {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(T entity) {
		entityManager.persist(entity);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public T update(T entity) {
		return entityManager.merge(entity);
	}

	@Override
	public void delete(T entity) {
		T mergedEntity = entityManager.merge(entity);
		entityManager.remove(mergedEntity);

	}

	@Override
	public T findById(Class<T> objectClass, Long id) {
		return entityManager.find(objectClass, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public T findEntity(String singleQuery, Object... params) {
		try {
			Query query = entityManager.createNamedQuery(singleQuery);

			for (int i = 0; i < params.length; i++) {
				query.setParameter(i + 1, params[i]);
			}

			return (T) query.getSingleResult();
		} catch (NoResultException exc) {
			return null;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findEntityList(String singleQuery, Object... params) {
		Query query = entityManager.createNamedQuery(singleQuery);

		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}

		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> objectClass) {
		return entityManager.createQuery("from " + objectClass.getName())
				.getResultList();
	}

}
