package com.valtech.tx.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.tx.entities.Tx;

public interface TxRepository extends JpaRepository<Tx, Integer> {

}
