package com.mcmproxibanque.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mcmproxibanque.dao.interfaces.IDao;

import javassist.bytecode.SignatureAttribute.TypeVariable;

public class DaoImpl<E> implements IDao<E> {

	@PersistenceContext(unitName = "persistenceUnit")
	protected EntityManager entityManager;
	
	protected E instance;
	private Class<E> entityClass;

	@Transactional
	@Override
	public void persist(E e) throws Exception {
		getEntityManager().persist(e);
	}

	@Transactional
	@Override
	public void merge(E e) throws Exception {
		getEntityManager().merge(e);
	}

	@Transactional(readOnly = true)
	@Override
	public void remove(Object id) throws Exception {
		getEntityManager().remove(findById(id));
	}

	@Transactional(readOnly = true)
	@Override
	public E findById(Object id) throws Exception {
		return (E) getEntityManager().find(getEntityClass(), id);
	}

	@Transactional(readOnly = true)
	@Override
	@SuppressWarnings("unchecked")
	public List<E> findAll() throws Exception {
		return getEntityManager().createQuery("Select t from " + getEntityClass().getSimpleName() + "t")
				.getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	public Class<E> getEntityClass() throws Exception {
		if (entityClass == null) {
			Type type = getClass().getGenericSuperclass();
			if (type instanceof ParameterizedType) {
				ParameterizedType paramType = (ParameterizedType) type;
				if (paramType.getActualTypeArguments().length == 2) {
					if (paramType.getActualTypeArguments()[1] instanceof TypeVariable) {
						throw new IllegalArgumentException("Can't find class using reflection");
					} else {
						entityClass = (Class<E>) paramType.getActualTypeArguments()[1];
					}
				} else {
					entityClass = (Class<E>) paramType.getActualTypeArguments()[0];
				}
			} else {
				throw new Exception("Can't find class using reflection");
			}
		}
		return entityClass;
	}

	public void setEntityClass(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	@Transactional(readOnly=true)
	@Override
	public long count() throws Exception {
		// TODO Auto-generated method stub
		return (Long) getEntityManager().createQuery("Select count(t) from " + getEntityClass().getSimpleName() + " t")
				.getSingleResult();
	}

}
