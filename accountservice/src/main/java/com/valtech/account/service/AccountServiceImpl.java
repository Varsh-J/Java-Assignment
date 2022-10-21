package com.valtech.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.account.entity.Account;
import com.valtech.account.repo.AccountRepository;
@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
//	@Autowired
//	private Account account;
	
	
	public Account createAccount(Account acc){
		return accountRepository.save(acc);
	}
	
	public Account updateAccount(Account acc){
		return accountRepository.save(acc);
	}
	
	public Account getAccount(long id){
		return accountRepository.findById(id).get();
	}
	
	public List<Account> getAllAccounts(){
		return accountRepository.findAll();
	}

	@Override
	public Account createSavingAccount(double balance) {
		
//		account.setAccountType(account.SAVING);
        Account a=new Account("SB",balance);
        return accountRepository.save(a);
		
	}

	@Override
	public Account createCurrentAccount(double balance) {
//		account.setAccountType(account.CURRENT);
        Account a=new Account("CA",balance);
        return accountRepository.save(a);
	}
	
	

}
