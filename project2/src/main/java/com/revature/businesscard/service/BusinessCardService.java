package com.revature.businesscard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.businesscard.dao.BusinessCardDAO;
import com.revature.businesscard.model.BusinessCard;

@Service
public class BusinessCardService {
    private BusinessCardDAO businessCardDao;

    @Autowired
    public BusinessCardService (BusinessCardDAO businessCardDAO) {
        this.businessCardDao = businessCardDao;
    }

    public BusinessCard createNewCard (
        //card fields
        String cardholderName,
        long cardNumber,
        String cardType,
        int expDate,
        int cvv,
        int billingZip,
        int pin,
        String cardName
    ) {
        BusinessCard newCard = new BusinessCard();
        //setting the attribute to the new card
        newCard.setCardholderName(cardholderName);
        newCard.setCardNumber(cardNumber);
        newCard.setCardType(cardType);
        newCard.setExpDate(expDate);
        newCard.setCvv(cvv);
        newCard.setBillingZip(billingZip);
        newCard.setPin(pin);
        newCard.setCardName(cardName);

            //saving the card
        BusinessCard savedCard = businessCardDao.save(newCard);

        return savedCard;
    }
}
