package com.revature.controller;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/newCard")
    public ResponseEntity<PersonalCardDTO> createCard(@RequestBody PersonalCardDTO request, @RequestHeader("Authorization") String token) {
        JwtUtils jwtUtils = new JwtUtils();
        Claims claims = jwtUtils.extractClaims(token.replace("Bearer", ""));
        String firstName = claims.get("firstName", String.class);
        String lastName = claims.get("lastName", String.class);

        // Instead of referencing the `PersonalCard` class, use a generic data structure
        Map<String, Object> cardData = new HashMap<>();
        cardData.put("cardType", request.getCardType());
        cardData.put("firstName", firstName);
        cardData.put("lastName", lastName);
        cardData.put("pin", request.getPin());
        cardData.put("billingZip", request.getBillingZip());

        // Create a PersonalCardDTO with the relevant data
        PersonalCardDTO personalCardDTO = new PersonalCardDTO();
        personalCardDTO.setCardType(cardData.get("cardType").toString());
        personalCardDTO.setFirstName(cardData.get("firstName").toString());
        personalCardDTO.setLastName(cardData.get("lastName").toString());
        personalCardDTO.setPin(Short.parseShort(cardData.get("pin").toString()));
        personalCardDTO.setBillingZip(Integer.parseInt(cardData.get("billingZip").toString()));

        // Return the PersonalCardDTO
        return ResponseEntity.ok(personalCardDTO);
    }
}
