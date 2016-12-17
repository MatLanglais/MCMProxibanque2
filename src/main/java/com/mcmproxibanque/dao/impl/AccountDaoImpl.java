package com.mcmproxibanque.dao.impl;

import com.mcmproxibanque.model.Account;

import org.springframework.stereotype.Component;

import com.mcmproxibanque.dao.interfaces.IAccountDao;

@Component
public class AccountDaoImpl extends DaoImpl<Account> implements IAccountDao {

}
