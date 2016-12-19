package com.mcmproxibanque.dao.impl;

import com.mcmproxibanque.model.Account;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mcmproxibanque.dao.interfaces.IAccountDao;

@Component
@Transactional
public class AccountDaoImpl extends DaoImpl<Account> implements IAccountDao {

}
