package com.revature.microservice;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.function.Supplier;

import com.revature.daos.TransactionDAO;
import com.revature.models.User;
import com.revature.models.Transaction;

@ExtendWith(MockitoExtension.class)
public class ViewTransactionsTest {

    @Mock
    private TransactionDAO transactionDAO;

    @InjectMocks
    private TransactionService transactionService;

    @Test
    public void testGetAllTransactions() {
        // Given
        User mockUser1 = new User(47, "bobert", "password", "bob", "ert",
                "bobert@bob.ert", "1-800-bobert", 1000);
        User mockUser2 = new User(69, "zekerton", "password", "zeke", "erton",
                "zekerton@zeke.erton", "1-800-zeke", 5000);

        Transaction mockTransaction1 = new Transaction(1, "gimme hundred", 100, mockUser1, mockUser2);
        Transaction mockTransaction2 = new Transaction(2, "gimme 200", 200, mockUser2, mockUser1);
        List<Transaction> mockTransactions = Arrays.asList(mockTransaction1, mockTransaction2);

        // Mock behavior
        when(transactionDAO.findAll()).thenReturn(mockTransactions);

        // Test the method
        Supplier<List<Transaction>> supplier = transactionService.getAllTransactions();
        List<Transaction> transactions = supplier.get();

        // Assertions
        verify(transactionDAO, times(1)).findAll();
        assertEquals(mockTransactions, transactions, "Returned transactions should match the mocked transactions");
    }
}
