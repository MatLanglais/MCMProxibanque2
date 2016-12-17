package com.mcmproxibanque.dto;

import javax.faces.bean.ManagedBean;

import com.mcmproxibanque.model.Transfer;

@ManagedBean
public class TransferController {

	private Transfer transfer;

	public Transfer getTransfer() {
		return transfer;
	}

	public void setTransfer(Transfer transfer) {
		this.transfer = transfer;
	}

	public TransferController() {
	}
	
	
}
