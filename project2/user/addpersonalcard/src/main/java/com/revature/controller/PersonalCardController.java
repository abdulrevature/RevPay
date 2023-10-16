package com.revature.controller;

import com.revature.model.PersonalCard;
import com.revature.service.PersonalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.revature.dtos.PersonalCardDTO;
import com.revature.service.PersonalCardService;
import com.revature.utils.JwtUtils;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class PersonalCardController {

    private final PersonalCardService personalCardService;

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
