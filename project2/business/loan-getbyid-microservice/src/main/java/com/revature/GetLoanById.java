package com.revature;

import com.revature.models.Loan;
import com.revature.service.GetLoanByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;

import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
public class GetLoanById {
    public static void main(String[] args) {
        SpringApplication.run(GetLoanById.class, args);
    }

    @Autowired
    GetLoanByIdService getLoanByIdService;

    @Bean
    public Function<APIGatewayProxyRequestEvent, String> getLoanById() {
        return input -> {
            //Extract path parameters from the event
            String loanIdString = input.getPathParameters().get("loanId");
            long loanId = Long.parseLong(loanIdString);

            //The rest of the function logic here
            Optional<Loan> loan = getLoanByIdService.getLoanById(loanId);
            return String.valueOf(loan);
        };
    }
}
