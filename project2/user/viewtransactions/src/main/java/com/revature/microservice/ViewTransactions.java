package com.revature.microservice;

import com.revature.daos.TransactionDAO;
import com.revature.models.MoneyRequest;
import com.revature.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

@SpringBootApplication
public class ViewTransactions {

//    private final TransactionService transactionService;
//
//    @Autowired
//    public ViewTransactions(TransactionService transactionService) {
//        this.transactionService = transactionService;
//    }

    public static void main(String[] args) {
        SpringApplication.run(ViewTransactions.class, args);
    }
}
