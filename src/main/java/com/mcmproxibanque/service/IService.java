package com.mcmproxibanque.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mcmproxibanque.model.Account;
/**
 * <b>Service IService</b>
 * <p>
 * Interface générale des services .
 * </p>
 * 
 * @author Claire Steinmacher
 * @author Mathilde Terrioux
 * @author Mathieu Langlais
 * 
 * @version 1
 * 
 */
@Component
public interface IService<E> {
	
	void persist(E e) throws Exception;

	void merge(E e) throws Exception;

	void remove(Object id) throws Exception;

	E findById(Object id) throws Exception;

	List<E> findAll() throws Exception;

	

}
