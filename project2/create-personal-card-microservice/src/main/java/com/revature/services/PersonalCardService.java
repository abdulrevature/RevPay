package com.revature.services;

import com.revature.daos.PersonalCardDAO;
import com.revature.models.PersonalCard;
import com.revature.utils.CardUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PersonalCardService {

    private final RestTemplate restTemplate;

    @Autowired
    private final PersonalCardDAO personalCardDAO;

    public PersonalCardService(final RestTemplate restTemplate, PersonalCardDAO personalCardDAO) {
        this.restTemplate = restTemplate;
        this.personalCardDAO = personalCardDAO;
    }

    public void addBankCard(PersonalCard personalCard) {
        personalCardDAO.save(personalCard);
    }

    public PersonalCardDAO createNewCard(String cardType, String firstName, String lastName, int pin, int billingZip) {
        CardUtils cardUtils = new CardUtils();
        PersonalCard newCard = new PersonalCard();

        // Card Generation

        long ccNumber = cardUtils.generateCardNumber(); // Generates a card number that satisfies the Luhn algorithm
        short expDate = cardUtils.generateExpDate();    // Expiry date generation.
        String cardholderName = firstName + " " + lastName;

        if (ccNumber != newCard.getCardNumber()) {
            newCard.setCardNumber(ccNumber);
        } else {
            while (ccNumber == newCard.getCardNumber()) {
                ccNumber = cardUtils.generateCardNumber();
            }
        }

        newCard.setCardType(cardType);
        newCard.setCardholderName(cardholderName);
        newCard.setExpDate(expDate);
        newCard.setCvv((short) cardUtils.generateCvv(ccNumber, expDate));
        newCard.setPin((short) pin);
        newCard.setBillingZip(billingZip);

        PersonalCard request = new PersonalCard(
                newCard.getCardholderName(),
                newCard.getCardType(),
                newCard.getCardNumber(),
                newCard.getPin(),
                newCard.getCvv(),
                newCard.getBillingZip(),
                newCard.getExpDate());

        personalCardDAO.save(personalCard);
        return request;

    }
}
