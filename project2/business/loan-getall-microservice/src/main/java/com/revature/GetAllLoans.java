package com.revature;

import com.revature.models.Loan;
import com.revature.service.GetAllLoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import java.util.function.Supplier;

@SpringBootApplication
@ComponentScan(basePackages = "com.revature")
public class GetAllLoans {
    public static void main(String[] args) {
        ApplicationContext context= SpringApplication.run(GetAllLoans.class, args);
        GetAllLoans ga = context.getBean(GetAllLoans.class);
        System.out.println(ga.getAllLoan().get());
    }


    GetAllLoansService getAllLoansService;

    @Autowired
    public GetAllLoans(GetAllLoansService getAllLoansService) {
        this.getAllLoansService = getAllLoansService;
    }


    @Bean
    public Supplier<String> getAllLoan() {
        List<Loan> loans = getAllLoansService.getAllLoans();
        return loans::toString;
    }
}
