package com.revature;

import com.revature.models.PersonalCard;
import com.revature.services.PersonalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class CreatePersonalCard {

    @Autowired
    private PersonalCardService ps;

    public static void main(String[] args) {
        SpringApplication.run(CreatePersonalCard.class, args);
    }

    @Bean
    public Consumer<PersonalCard> addPersonalCard() {
        return value -> {
            ps.addBankCard(value);
            System.out.println(value);
    }
}