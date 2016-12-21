package com.mcmproxibanque.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.mcmproxibanque.dao.interfaces.IAccountDao;
import com.mcmproxibanque.dao.interfaces.IDao;

import javassist.bytecode.SignatureAttribute.TypeVariable;
/**
 * <b>Implémentation DaoImpl</b>
 * <p>
 * Implémentation générale de l'interface {@link IDao}.
 * </p>
 * 
 * @author Claire Steinmacher
 * @author Mathilde Terrioux
 * @author Mathieu Langlais
 * 
 * @version 1
 * 

 * @see {@link IDao}
 * 
 */
public class DaoImpl<E> implements IDao<E> {
	private static final Logger LOGGER = LoggerFactory.getLogger(DaoImpl.class);
	
	@PersistenceContext(unitName = "persistenceUnit")
	protected EntityManager entityManager;
	
	protected E instance;
	private Class<E> entityClass;

	@Transactional
	@Override
	public void persist(E e) throws Exception {
		getEntityManager().persist(e);
		LOGGER.info("insertion en base de donnée d'un " + e.getClass().getCanonicalName());
	}

	@Transactional
	@Override
	public void merge(E e) throws Exception {
		getEntityManager().merge(e);
		LOGGER.info("modification de la base de donnée sur la table " + e.getClass().getCanonicalName());
	}

	@Transactional(readOnly = true)
	@Override
	public void remove(Object id) throws Exception {
		getEntityManager().createQuery("Delete from "+ getEntityClass().getSimpleName() +" t where t.id = "+id).executeUpdate();
		LOGGER.info("suppression d'une entité");
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
		return getEntityManager().createQuery("Select t from " + getEntityClass().getSimpleName() + " t")
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
