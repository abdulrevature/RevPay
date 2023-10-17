package com.revature.service;

import com.revature.daos.PersonalCardDAO;
import com.revature.models.PersonalCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalCardService {
    /*
    private final RestTemplate restTemplate;
    private final String daoBaseUrl; // Base URL of the DAO service

    public PersonalCardService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.daoBaseUrl = "[replace with actual URL]"; // Set the base URL of the DAO service
    }
     */
    // This generates card numbers.
    @Autowired
    private final PersonalCardDAO PCD;

    public PersonalCardService(PersonalCardDAO pcd){

        PCD = pcd;
    }


    public void addCreditCard(PersonalCard p){
        PCD.save(p);
    }

   /*
    public PersonalCard createNewCard(
            String cardType,
            String FirstName,
            String LastName,
            int pin,
            int billingZip) {

        CardUtils cardUtils = new CardUtils();
        PersonalCardDTO newCard = new PersonalCardDTO();

        // Card Generation
        // This will generate a card number that also satisfies the Luhn algorithm.
        long ccNumber = cardUtils.generateCardNumber();

        // Expiry Date generation.
        short expDate = cardUtils.generateExpDate();

        // Ideally this will take in information from the current user session at the controller layer. This merely
        // standardizes the data so that it is input into the database
        String cardholderName = FirstName + " " + LastName;


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
        newCard.setPin((short) pin);
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
        return newCard;
    }

    */
}