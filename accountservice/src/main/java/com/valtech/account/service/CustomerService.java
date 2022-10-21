package com.valtech.account.service;

import java.util.List;

import com.valtech.account.entity.Customer;

public interface CustomerService {

	Customer createCustomer(Customer cu);

	Customer updateCustomer(Customer cu);

	Customer getCustomer(int id);

	List<Customer> getAllCustomers();

}