package com.valtech.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.account.entity.Customer;
import com.valtech.account.repo.CustomerRepository;
@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer createCustomer(Customer cu){
		return customerRepository.save(cu);
	}

	public Customer updateCustomer(Customer cu){
		return customerRepository.save(cu);
	}
	
	public Customer getCustomer(int id){
		return customerRepository.findById(id).get();
	}
	
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
}
