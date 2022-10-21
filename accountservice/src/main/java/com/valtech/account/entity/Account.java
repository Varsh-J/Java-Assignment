package com.valtech.account.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String accountType;
	private double balance;
	private LocalDateTime creationDate;
	private LocalDateTime lastUpdatedDate;
	private boolean active;
	 @ManyToMany(targetEntity=Customer.class,cascade={CascadeType.MERGE,CascadeType.PERSIST})
	  private Set<Customer> customers;
	 
	 public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
	 
	 public Set<Customer> getCustomers() {
		return customers;
	}
	
    public static final String SAVING="SB";
    public static final String CURRENT="CB";
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(long id,String accountType, double balance, LocalDateTime creationDate, LocalDateTime lastUpdatedDate,boolean active) {
		super();
		
		this.accountType = accountType;
		this.balance = balance;
		this.creationDate = creationDate;
		this.lastUpdatedDate =lastUpdatedDate;
		this.active = false;
	}
	
	public Account(String accountType, double balance) {
        super();
        this.accountType = accountType;
        this.balance = balance;
        this.creationDate=LocalDateTime.now();
        this.lastUpdatedDate=LocalDateTime.now();
        this.active=false;
    }
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public LocalDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
	

}
