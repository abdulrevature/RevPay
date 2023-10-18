package com.revature.microservice;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.daos.TransactionDAO;
import com.revature.models.Transaction;
import org.springframework.transaction.annotation.Transactional;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import com.revature.daos.TransactionDAO;

@SpringBootTest
@Transactional
public class ViewTransactionsPersistenceTest {

    @Autowired
    private TransactionDAO transactionDAO;

    @Autowired
    private Supplier<List<Transaction>> allTransactionsSupplier;

    @Test
    public void testTransactionPersistence() {
        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(500);
        newTransaction.setDescription("HELLO WORLD");
        transactionDAO.save(newTransaction);

        List<Transaction> transactions = allTransactionsSupplier.get();
        assertNotNull(transactions);
        assertTrue(transactions.contains(newTransaction));
    }
}