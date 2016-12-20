package com.mcmproxibanque.dao.interfaces;

import java.util.Collection;
import java.util.List;

import com.mcmproxibanque.model.Advisor;
import com.mcmproxibanque.model.Customer;

public interface IDao<E> {

	void persist(E e) throws Exception;

	void merge(E e) throws Exception;

	void remove(Object id) throws Exception;

	E findById(Object id) throws Exception;

	List<E> findAll() throws Exception;
	
	long count() throws Exception;

	
}
