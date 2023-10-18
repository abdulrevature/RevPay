package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@SpringBootApplication
public class GetAllLoans {
    public static void main(String[] args) {
        SpringApplication.run(GetAllLoans.class, args);
    }

    //get all items
    @Bean //Remember, we need these functions to be "functional beans" to be noticed by lambda
    public Supplier<List<String>> getLoans() {
        //this is a supplier function, which will return data to the user
        //realistically, this is where we'd defer to the service (which would get data from the DAO etc)
        //but here, we'll just an ArrayList of Strings to represent items
        ArrayList<String> items = new ArrayList<>();
        return () -> items; //remember, Java lambdas either need to take in some value(s) or just ()
    }
}
