package com.revature;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class UpdateLoanApproval {
    public static void main(String[] args) {
        SpringApplication.run(UpdateLoanApproval.class, args);
    }

    //get item by id (path param example)
    @Bean
    public Function<APIGatewayProxyRequestEvent, String> getItemById() {
        return input -> {
            //Extract path parameters from the event
            String itemId = input.getPathParameters().get("itemId");
            //The rest of the function logic here
            String response = "Received itemId: " + itemId;
            return response;
        };
    }
}
