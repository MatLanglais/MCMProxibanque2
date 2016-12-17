package com.mcmproxibanque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcmproxibanque.dao.interfaces.IAccountDao;
import com.mcmproxibanque.model.Account;

@Component
public class AccountService extends ServiceImpl<Account> implements IService<Account> {
	
	@Autowired
	IAccountDao accountDaoImpl;	

}
