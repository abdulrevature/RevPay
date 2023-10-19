package com.revature.SpringWithLambda;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.revature.SpringWithLambda.daos.LoanDAO;
import com.revature.SpringWithLambda.service.GetAllLoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.revature.SpringWithLambda.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class SpringWithLambdaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWithLambdaApplication.class, args);
    }

    //Below, I'll be defining functions that we will package and deploy onto Lambdas

    //I'll be commenting functions out to get unique jar files
    //in the real world, these functions will typically be separate apps

//	@Bean //These functions are considered FUNCTIONAL BEANS - they're executed by lambda functions
//	//this is a FUNCTION type method. takes input, returns output. in this case, Strings.
//	public Function<String, String> uppercase(){
//
//		return userInput -> userInput.toUpperCase(); //return the inputted String in uppercase
//
//	}

    @Autowired
    LoanDAO loanDAO;


    //get all items
//	@Bean
//	public Supplier<String> getAllLoan() {
//		List<Loan> loans = loanDAO.findAll();
//		return loans::toString;
//	}

    //insert item
    @Bean
    public Consumer<String> insertLoan() {

        //since this is a Consumer type function, we won't return anything
        //but we CAN see this inputted value printed in the logs for our Lambda

        return value -> System.out.println(value);

    }
//
//
//	//get item by id (path param example)
//	@Bean
//	public Function<APIGatewayProxyRequestEvent, String> getItemById() {
//		return input -> {
//			//Extract path parameters from the event
//			String itemId = input.getPathParameters().get("itemId");
//
//			//The rest of the function logic here
//			String response = "Received itemId: " + itemId;
//
//			return response;
//		};
//	}

}
