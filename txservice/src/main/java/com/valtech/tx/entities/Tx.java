package com.valtech.tx.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Tx {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private float amount;
	private LocalDateTime txTime;
	private long accountId;
	
	public Tx(float amount){
		this.amount=amount;
	}
	

	public Tx() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Tx(long id, float amount, LocalDateTime txTime, long accountId) {
		super();
		this.id = id;
		this.amount = amount;
		this.txTime = txTime;
		this.accountId = accountId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public LocalDateTime getTxTime() {
		return txTime;
	}
	public void setTxTime(LocalDateTime txTime) {
		this.txTime = txTime;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	
	

}
