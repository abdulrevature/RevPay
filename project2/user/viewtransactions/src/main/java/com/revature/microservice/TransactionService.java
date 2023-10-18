package com.revature.microservice;

import com.revature.daos.TransactionDAO;
import com.revature.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class TransactionService {

    private final TransactionDAO transactionDAO;

    @Autowired
    public TransactionService(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    public Supplier<List<Transaction>> getAllTransactions(){
        List<Transaction> transactions = transactionDAO.findAll();
        return () -> transactions;
    }

}
