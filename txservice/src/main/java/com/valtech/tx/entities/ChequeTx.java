package com.valtech.tx.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ctx")
public class ChequeTx  extends Tx{
	
	private int chequeNo;
	private boolean outstation;
	private float collectionCharges;
	
	public ChequeTx() {
		super();
		
	}

	public ChequeTx(float amount,int chequeNo, boolean outstation, float collectionCharges) {
		super(amount);
		this.chequeNo = chequeNo;
		this.outstation = outstation;
		this.collectionCharges = collectionCharges;
	}

	public int getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(int chequeNo) {
		this.chequeNo = chequeNo;
	}

	public boolean isOutstation() {
		return outstation;
	}

	public void setOutstation(boolean outstation) {
		this.outstation = outstation;
	}

	public float getCollectionCharges() {
		return collectionCharges;
	}

	public void setCollectionCharges(float collectionCharges) {
		this.collectionCharges = collectionCharges;
	}

	@Override
	public String toString() {
		return "ChequeTx [chequeNo=" + chequeNo + ", outstation=" + outstation + ", collectionCharges="
				+ collectionCharges + ", getId()=" + getId() + ", getAmount()=" + getAmount() + "]";
	}

	
	
	
	
	

}
