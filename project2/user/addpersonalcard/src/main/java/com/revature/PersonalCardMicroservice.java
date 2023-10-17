package com.revature;

import com.revature.model.PersonalCard;
import com.revature.service.PersonalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
public class PersonalCardMicroservice {

    @Autowired
    private PersonalCardService ps;

    public static void main(String[] args) { SpringApplication.run(PersonalCardMicroservice.class, args); }


    @Bean
    public ResponseEntity<PersonalCard> createCard(@RequestBody PersonalCard personalCard) {
        PersonalCard pc = PersonalCardService.createNewCard("Debit", "Testophiles", "Examundo", 123, 01234);
        return ResponseEntity.ok(pc);
    }
}
