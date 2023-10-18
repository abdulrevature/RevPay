package com.revature;

import com.revature.models.Loan;
import com.revature.service.GetLoanByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;
import java.util.function.Supplier;

@SpringBootApplication
public class GetLoanById {
    public static void main(String[] args) {
        SpringApplication.run(GetLoanById.class, args);
    }

    @Autowired
    GetLoanByIdService getLoanByIdService;

    long loanId = 1;

    @Bean
    public Supplier<String> getAllLoan() {
        Optional<Loan> loan = getLoanByIdService.getLoanById(loanId);
        return loan::toString;
    }
}
