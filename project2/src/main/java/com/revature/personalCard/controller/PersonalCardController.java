package com.revature.personalCard.controller;
import com.revature.personalCard.model.PersonalCard;
import com.revature.personalCard.service.PersonalCardService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class PersonalCardController {

    private PersonalCardService personalCardService;

    @Autowired
    public PersonalCardController(PersonalCardService pcService) {
        this.personalCardService = pcService;
    }



    @PostMapping("/newCard")
    public ResponseEntity<PersonalCard> createCard(@RequestBody PersonalCard personalCard, @RequestHeader("Authorization") String token) {

        Claims claims = jwtUtil.extractClaims(token.replace("Bearer", ""));
        String firstName = claims.get("firstName", String.class);
        String lastName = claims.get("lastName", String.class);


        return ResponseEntity.ok(PersonalCardService.createNewCard("Debit", firstName, lastName, (short) personalCard.getPin(), personalCard.getBillingZip()));
    }
}
