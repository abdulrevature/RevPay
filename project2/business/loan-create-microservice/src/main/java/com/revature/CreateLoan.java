package com.revature;

import com.revature.models.Loan;
import com.revature.service.CreateLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class CreateLoan {
    public static void main(String[] args) {
        SpringApplication.run(CreateLoan.class, args);
    }

    @Autowired
    CreateLoanService createLoanService;

    @Bean
    public Consumer<Loan> createLoan() {

        //since this is a Consumer type function, we won't return anything
        //but we CAN see this inputted value printed in the logs for our Lambda

        return value -> System.out.println(value);
    }
}
