package com.revature;

import com.revature.models.Loan;
import com.revature.service.GetAllLoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionalSpringApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Supplier;

@SpringBootConfiguration
public class GetAllLoans implements Supplier<String> {
    public static void main(String[] args) {
        FunctionalSpringApplication.run(GetAllLoans.class, args);

    }


    GetAllLoansService getAllLoansService;

    @Autowired
    public GetAllLoans(GetAllLoansService getAllLoansService) {
        this.getAllLoansService = getAllLoansService;
    }

    @Override
    public String get() {
        return getAllLoansService.getAllLoans().toString();
    }
}
