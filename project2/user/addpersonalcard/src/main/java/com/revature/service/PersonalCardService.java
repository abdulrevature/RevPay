package com.revature.service;


import com.revature.dtos.PersonalCardDTO;
import com.revature.utils.CardUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class PersonalCardService {

    private final RestTemplate restTemplate;
    private final String daoBaseUrl; // Base URL of the DAO service

    public PersonalCardService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.daoBaseUrl = "[replace with actual URL]"; // Set the base URL of the DAO service
    }

    public void createCard(String cardType, String firstName, String lastName, short pin, int billingZip) {

        CardUtils cardUtils = new CardUtils();
        PersonalCardDTO newCard = new PersonalCardDTO();

        // Card Generation
        // This will generate a card number that also satisfies the Luhn algorithm.
        long ccNumber = cardUtils.generateCardNumber();

        // Expiry Date generation.
        short expDate = cardUtils.generateExpDate();

        // Ideally this will take in information from the current user session at the controller layer. This merely
        // standardizes the data so that it is input into the database
        String cardholderName = firstName + " " + lastName;


        // Verify Card Number doesn't exit before editing.
        if (ccNumber != newCard.getCardNumber()) {
            newCard.setCardNumber(ccNumber);
        } else {
            while (ccNumber == newCard.getCardNumber()) {
                // If the card number exists, rerun cardUtils until such a time that a match can't be found.
                ccNumber = cardUtils.generateCardNumber();
            }
        }

        newCard.setCardType(cardType);
        newCard.setCardHolderName(cardholderName);
        newCard.setCardNumber(ccNumber);
        newCard.setExpDate(expDate);
        newCard.setCvv((short) cardUtils.generateCVV(ccNumber, expDate));
        newCard.setPin(pin);
        newCard.setBillingZip(billingZip);

        PersonalCardDTO request = new PersonalCardDTO(
                newCard.getCardHolderName(),
                newCard.getCardType(),
                newCard.getCardNumber(),
                newCard.getPin(),
                newCard.getCvv(),
                newCard.getBillingZip(),
                newCard.getExpDate());

        String createCardUrl = daoBaseUrl + "/createPersonalCard";

        restTemplate.postForObject(createCardUrl, request, Void.class);
    }
}