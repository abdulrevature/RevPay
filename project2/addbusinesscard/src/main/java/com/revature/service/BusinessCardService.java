package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.BusinessCardDAO;
import com.revature.model.BusinessCard;
import com.revature.personalCard.util.CardUtils;

@Service
public class BusinessCardService {
    private BusinessCardDAO businessCardDao;

    @Autowired
    public BusinessCardService (BusinessCardDAO businessCardDAO) {
        this.businessCardDao = businessCardDao;
    }

    public BusinessCard createBusinessCard (
        //card fields
        String cardholderName,
        long cardNumber,
        String cardType,
        int cvv,
        int billingZip,
        int pin
        
    ) {
        BusinessCard newCard = new BusinessCard();
          CardUtils cardUtils = new CardUtils();

        long ccNumber = cardUtils.generateCardNumber();
        short expDate = cardUtils.generateExpDate();
        //setting the attribute to the new card

        if (ccNumber != newCard.getCardNumber()) {
            newCard.setCardNumber(ccNumber);
        } else {
            while (ccNumber == newCard.getCardNumber()) {
                // If the card number exists, rerun cardUtils until such a time that a match can't be found.
                ccNumber = cardUtils.generateCardNumber();
            }
        }
        newCard.setCardholderName(cardholderName);
        newCard.setCardType(cardType);
        newCard.setExpDate(expDate);
        newCard.setCvv(cardUtils.generateCVV(ccNumber, expDate));
        newCard.setBillingZip(billingZip);
        newCard.setPin(pin);
        

            //saving the card
        BusinessCard savedCard = businessCardDao.save(newCard);

        return savedCard;
    }

   
}
