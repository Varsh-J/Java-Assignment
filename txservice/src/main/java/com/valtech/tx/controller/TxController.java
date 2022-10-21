package com.valtech.tx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.tx.entities.Tx;
import com.valtech.tx.service.TxService;

@RestController
public class TxController {
    @Autowired
    private TxService txService;
    
    @PostMapping("/api/tx")
    public Tx createTx(Tx tx) {
        return txService.createTx(tx);
    }
    
   
   
    
}