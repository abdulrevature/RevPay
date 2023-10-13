package com.revature.businessCard.controller;

import com.revature.businessCard.model.BusinessCard;
import com.revature.businessCard.service.BusinessCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/businesscards")
@RequestMapping("/") // Not sure how this will work for microservices. I assume either this or the above will work.
public class BusinessCardController {

    @Autowired
    private BusinessCardService businessCardService;

    // Business Card
    @PostMapping
    public ResponseEntity<BusinessCard> createBusinessCard(@RequestBody BusinessCard businessCard) {
        BusinessCard createdBusinessCard = businessCardService.createBusinessCard(businessCard);
        return new ResponseEntity<>(createdBusinessCard, HttpStatus.CREATED);
    }

    // Get all Business Cards
    @GetMapping
    public ResponseEntity<List<BusinessCard>> getAllBusinessCards() {
        List<BusinessCard> businessCards = businessCardService.getAllBusinessCards();
        return new ResponseEntity<>(businessCards, HttpStatus.OK);
    }

    // Get a specific Business Card by its ID
    @GetMapping("/{id}")
    public ResponseEntity<BusinessCard> getBusinessCardById(@PathVariable long id) {
        BusinessCard businessCard = businessCardService.getBusinessCardById(id);
        return new ResponseEntity<>(businessCard, HttpStatus.OK);
    }

    // Update a Business Card
    @PutMapping("/{id}")
    public ResponseEntity<BusinessCard> updateBusinessCard(@PathVariable long id, @RequestBody BusinessCard businessCard) {
        BusinessCard updatedBusinessCard = businessCardService.updateBusinessCard(id, businessCard);
        return new ResponseEntity<>(updatedBusinessCard, HttpStatus.OK);
    }

    // Delete a Business Card
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBusinessCard(@PathVariable long id) {
        businessCardService.deleteBusinessCard(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
