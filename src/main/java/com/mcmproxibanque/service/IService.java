package com.mcmproxibanque.service;

import java.util.List;

public interface IService<E> {
	
	void persist(E e) throws Exception;

	void merge(E e) throws Exception;

	void remove(Object id) throws Exception;

	E findById(Object id) throws Exception;

	List<E> findAll() throws Exception;

}
