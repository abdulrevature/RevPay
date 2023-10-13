package com.revature.businessCard.model;

import org.springframework.stereotype.Component;
import javax.persistence.*;

@Entity
@Table
@Component
public class BusinessCard {
    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JoinColumn(name="accountId") private long accountId;
    @Column
    private String cardholderName;
    @Column private long cardNumber;
    @Column private String cardType;
    @Column private int expDate;
    @Column private int cvv;
    @Column private int billingZip;
    @Column private int pin;
    @Column private String cardName;

    // Constructors

    public BusinessCard(){};
    // Getters and Setters
    public BusinessCard(long id) { this.id = id; }

    public BusinessCard(long cardNumber, int expDate, int cvv, int billingZip) {
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.cvv = cvv;
        this.billingZip = billingZip;
    }

    public BusinessCard(String cardholderName, long cardNumber, int expDate, int cvv, int billingZip) {
        this.cardholderName = cardholderName;
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.cvv = cvv;
        this.billingZip = billingZip;
    }

    public BusinessCard(
            long id,
            long accountId,
            String cardholderName,
            long cardNumber,
            String cardType,
            int expDate,
            int cvv,
            int billingZip,
            int pin,
            String cardName
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
        this.cardName = cardName;
    }

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
    public String getCardName() { return cardName; }

    // --- Setters
}
