package com.revature.personalcard.service;

import com.revature.personalcard.model.PersonalCard;
import com.revature.personalcard.util.CardUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.personalcard.dao.PersonalCardDAO;

import java.util.Random;

@Service
public class PersonalCardService {

    private PersonalCardDAO personalCardDao;

    @Autowired
    public PersonalCardService(PersonalCardDAO personalCardDao) {this.personalCardDao = personalCardDao; }

    // This generates card numbers.
    public PersonalCard createNewCard(
            String cardType,
            String FirstName,
            String LastName,
            int pin,
            int billingZip) {

        // Instantiate the personal card model.
        PersonalCard newCard = new PersonalCard();
        CardUtils cardUtils = new CardUtils();

        long ccNumber = cardUtils.generateCardNumber();
        short expDate = cardUtils.generateExpDate();

        // Ideally this will take in information from the current user session at the controller layer. This merely
        // standardizes the data so that it is input into the database
        String cardholderName = FirstName + " " + LastName;

        // Card Generation
        // This will generate a card number which satisfies the Luhn algorithm
        Random random = new Random();

        newCard.setCardType(cardType);

        // Verify Card Number doesn't exit before editing.
        if (ccNumber != newCard.getCardNumber()) {
            newCard.setCardNumber(ccNumber);
        } else {
            while (ccNumber == newCard.getCardNumber()) {
                // If the card number exists, rerun cardUtils until such a time that a match can't be found.
                ccNumber = cardUtils.generateCardNumber();
            }
        }

        newCard.setExpDate(expDate);
        newCard.setCvv(cardUtils.generateCVV(ccNumber, expDate));
        newCard.setPin(pin);
        newCard.setBillingZip(billingZip);

        return newCard;
    }
}