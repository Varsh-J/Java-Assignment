package com.valtech.account.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String moblie;
	private LocalDate birthDate;
	private String address;
	private String customerType;
	private int pincode;
	 @ManyToMany(targetEntity=Account.class,cascade={CascadeType.MERGE,CascadeType.PERSIST})
	  private Set<Account> accounts;
	
	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	
	public Set<Account> getAccounts() {
		return accounts;
	}
	
	
	
	public Customer() {}
		
	public Customer(String name, String email, String moblie, LocalDate birthDate, String address,
			String customerType, int pincode) {
		super();
		
		this.name = name;
		this.email = email;
		this.moblie = moblie;
		this.birthDate = birthDate;
		this.address = address;
		this.customerType = customerType;
		this.pincode = pincode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMoblie() {
		return moblie;
	}
	public void setMoblie(String moblie) {
		this.moblie = moblie;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	

}
