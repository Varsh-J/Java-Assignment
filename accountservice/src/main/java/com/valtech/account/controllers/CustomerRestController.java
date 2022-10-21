package com.valtech.account.controllers;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.account.entity.Account;
import com.valtech.account.entity.Customer;
import com.valtech.account.service.CustomerService;
@RestController
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/api/customer")
	public Customer createCustomer(@RequestBody Customer cu){
		return customerService.createCustomer(cu);
	}

}
