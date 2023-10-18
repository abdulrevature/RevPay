package com.revature;

import com.revature.models.Loan;
import com.revature.service.GetAllLoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Supplier;

@SpringBootApplication
public class GetAllLoans {
    public static void main(String[] args) {
        SpringApplication.run(GetAllLoans.class, args);
    }

    @Autowired
    GetAllLoansService createLoanService;

    @Bean
    public Supplier<String> getAllLoan() {
        List<Loan> loans = createLoanService.getAllLoans();
        return loans::toString;
    }
}
