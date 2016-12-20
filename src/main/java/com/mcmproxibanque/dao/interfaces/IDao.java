package com.mcmproxibanque.dao.interfaces;

import java.util.List;

public interface IDao<E> {

	void persist(E e) throws Exception;

	void merge(E e) throws Exception;

	void remove(Object id) throws Exception;

	E findById(Object id) throws Exception;

	List<E> findAll() throws Exception;
	
	long count() throws Exception;

	
}
