package com.valtech.tx.entities;

import java.time.LocalDateTime;

public class Transfer extends Tx{
	
	private String fromAccount;
	private String toAccount;

	
	public Transfer() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	public String getFromAccount() {
		return fromAccount;
	}
	public Transfer(float amount, String fromAccount, String toAccount) {
	super(amount);
	this.fromAccount = fromAccount;
	this.toAccount = toAccount;
     }

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}
	public String getToAccount() {
		return toAccount;
	}
	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}
	
	

}
