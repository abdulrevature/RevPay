package com.revature.personalCard.controller;

import com.revature.personalCard.model.PersonalCard;
import com.revature.personalCard.service.PersonalCardService;
import org.springframework.beans.factory.annotation.Autowired;
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



    @PostMapping("/newCard")
    public ResponseEntity<PersonalCard> createCard(@RequestBody PersonalCard personalCard) {
        PersonalCard pc = PersonalCardService.createNewCard("Debit", )
    }
}
