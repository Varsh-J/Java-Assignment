package com.valtech.tx.service;

import java.util.List;

import com.valtech.tx.entities.Tx;

public interface TxService {

	Tx createTx(Tx tx);

	Tx update(Tx tx);

	Tx getTx(int id);

	List<Tx> getAllTxs();

}