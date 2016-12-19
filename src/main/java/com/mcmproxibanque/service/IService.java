package com.mcmproxibanque.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mcmproxibanque.model.Advisor;
import com.mcmproxibanque.model.Customer;

@Component
public interface IService<E> {
	
	void persist(E e) throws Exception;

	void merge(E e) throws Exception;

	void remove(Object id) throws Exception;

	E findById(Object id) throws Exception;

	List<E> findAll() throws Exception;

	

}
