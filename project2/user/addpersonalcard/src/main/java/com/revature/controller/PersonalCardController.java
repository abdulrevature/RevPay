package com.revature.controller;

import com.revature.model.PersonalCard;
import com.revature.service.PersonalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PersonalCardController {

    private PersonalCardService personalCardService;

    @Autowired
    public PersonalCardController(PersonalCardService pcService) {
        this.personalCardService = pcService;
    }



    @Bean
    public ResponseEntity<PersonalCard> createCard(@RequestBody PersonalCard personalCard) {
        PersonalCard pc = PersonalCardService.createNewCard("Debit", "Testophiles", "Examundo", 123, 01234);
        return ResponseEntity.ok(pc);
    }
}
