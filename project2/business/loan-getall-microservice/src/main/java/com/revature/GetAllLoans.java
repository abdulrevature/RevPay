package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class GetAllLoans {
    public static void main(String[] args) {
        SpringApplication.run(GetAllLoans.class, args);
    }

    @Bean
    public Consumer<String> insertItem() {
        // This return is only used to see the inputted value
        return System.out::println;
    }
}
