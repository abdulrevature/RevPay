package com.revature;

import com.revature.models.Loan;
import com.revature.service.CreateLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.function.Consumer;

@SpringBootApplication
public class SpringWithLambdaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWithLambdaApplication.class, args);
    }

    @Autowired
    private CreateLoanService createLoanService;

    @Bean
    public Consumer<String> createLoan(@RequestBody Loan loan, @PathVariable("businessId") long businessId) {
//    public Consumer<String> createLoan() {
//    Loan loan = new Loan(new BigDecimal("110.03"), false, false, new BigDecimal("0.03"), 12, LocalDateTime.parse("2016-11-09T11:44:44.79"));
        try {
            Loan insertedLoan = createLoanService.createLoan(loan, businessId);
            return value -> System.out.println(insertedLoan.toString());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return value -> System.out.println("Creation Failure");
        }
    }

}
