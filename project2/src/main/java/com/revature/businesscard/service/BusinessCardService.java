package com.revature.businesscard.service;

import java.util.List;
import java.util.Optional;

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

    public BusinessCard createBusinessCard (
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

    public List<BusinessCard> getAllBusinessCards() {
        return businessCardDao.findAll();
    }

    public BusinessCard getBusinessCardById(long id) {
        Optional<BusinessCard> optionalBusinessCard = businessCardDao.findById((int)id);
        return optionalBusinessCard.orElseThrow(() -> new BusinessCardNotFoundException(id));
    }

    public BusinessCard updateBusinessCard(long id, BusinessCard businessCard) {
        Optional<BusinessCard> existingBusinessCard = businessCardDao.findById((int)id);
        
        if (existingBusinessCard.isPresent()) {
            businessCard.setId(id);
            return businessCardDao.save(businessCard);
        } else {
            throw new BusinessCardNotFoundException(id);
        }

    }

        public void deleteBusinessCard(long id) {
            if (businessCardDao.existsById((int)id)) {
                businessCardDao.deleteById((int)id);
            } else {
                throw new BusinessCardNotFoundException(id);
            }
    }
}
