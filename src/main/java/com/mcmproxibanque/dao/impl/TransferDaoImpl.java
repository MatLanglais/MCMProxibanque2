package com.mcmproxibanque.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mcmproxibanque.dao.interfaces.ITransferDao;
import com.mcmproxibanque.model.Transfer;

@Component
@Transactional
public class TransferDaoImpl extends DaoImpl<Transfer> implements ITransferDao {

}
