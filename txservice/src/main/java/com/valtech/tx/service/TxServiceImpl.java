package com.valtech.tx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.tx.entities.Tx;
import com.valtech.tx.repo.TxRepository;
@Service
public class TxServiceImpl implements TxService {
	
	@Autowired
	private TxRepository txRepository;
	
	public Tx createTx(Tx tx){
		return txRepository.save(tx);
		
	}
	
	public Tx update(Tx tx){
		return txRepository.save(tx);
	}
	
	public Tx getTx(int id){
		return txRepository.findById(id).get();
		
	}
	
	public List<Tx> getAllTxs(){
		return txRepository.findAll();
	}

}
