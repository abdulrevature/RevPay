package com.revature.personal_card.model;

import org.springframework.stereotype.Component;
import javax.persistence.*;

@Entity
@Table
@Component
public class PersonalCard {

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="accountid") private long accountId;
    @Column private String cardholderName;
    @Column private long cardNumber;
    @Column private String cardType;
    @Column private int expDate;
    @Column private int cvv;
    @Column private int billingZip;
    @Column private int pin;

    // Constructors
    public PersonalCard() {}

    public PersonalCard(long id) { this.id = id; }

    public PersonalCard(long cardNumber, int expDate, int cvv, int billingZip) {
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.cvv = cvv;
        this.billingZip = billingZip;
    }

    public PersonalCard(String cardholderName, long cardNumber, int expDate, int cvv, int billingZip) {
        this.cardholderName = cardholderName;
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.cvv = cvv;
        this.billingZip = billingZip;
    }

    public PersonalCard(
            long id,
            long accountId,
            String cardholderName,
            long cardNumber,
            String cardType,
            int expDate,
            int cvv,
            int billingZip,
            int pin
    ) {
        this.id = id;
        this.accountId = accountId;
        this.cardholderName = cardholderName;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.expDate = expDate;
        this.cvv = cvv;
        this.billingZip = billingZip;
        this.pin = pin;
    }

    // Getters and Setters
    // --- Getters
    public long getId() { return id; }
    public long getAccountId() { return accountId; }
    public String getCardholderName() { return cardholderName; }
    public long getCardNumber() { return cardNumber; }
    public String getCardType() { return cardType; }
    public int getExpDate() { return expDate; }
    public int getCvv() { return cvv; }
    public int getBillingZip() { return billingZip; }
    public int getPin() { return pin; }

    // --- Setters
    public void setId(long id) { this.id = id; }
    public void setAccountId(long accountId) { this.accountId = accountId; }
    public void setCardholderName(String cardholderName) { this.cardholderName = cardholderName; }
    public void setCardNumber(long cardNumber) { this.cardNumber = cardNumber; }
    public void setCardType(String cardType) { this.cardType = cardType; }
    public void setExpDate(int expDate) { this.expDate = expDate; }
    public void setCvv(int cvv) { this.cvv = cvv; }
    public void setBillingZip(int billingZip) { this.billingZip = billingZip; }
    public void setPin(int pin) { this.pin = pin; }
}
