package com.valtech.tx.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("atx")
public class WithdrawTx extends Tx {
	
	private int atmNo;
	private String location;
	
	public WithdrawTx() {
		super();
		
	}

	public WithdrawTx(float amount,int atmNo, String location) {
		super(amount);
		this.atmNo = atmNo;
		this.location = location;
	}

	public int getAtmNo() {
		return atmNo;
	}

	public void setAtmNo(int atmNo) {
		this.atmNo = atmNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "AtmTx [atmNo=" + atmNo + ", location=" + location + ", getId()=" + getId() + ", getAmount()="
				+ getAmount() + "]";
	}


}
