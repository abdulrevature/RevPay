package com.revature.personalCard.model;

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

    @JoinColumn(name="userId") private long userId;
    @JoinColumn(name="accountId") private long accountId;
    @Column private String cardholderName;
    @Column private long cardNumber;
    @Column private String cardType;
    @Column private short expDate;
    @Column private short cvv;
    @Column private int billingZip;
    @Column private short pin;
    @Column private String cardName;

    // Constructors
    public PersonalCard() {}

    public PersonalCard(long id) { this.id = id; }

    public PersonalCard(long cardNumber, short expDate, short cvv, int billingZip) {
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.cvv = cvv;
        this.billingZip = billingZip;
    }

    public PersonalCard(String cardholderName, long cardNumber, short expDate, short cvv, int billingZip) {
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
            short expDate,
            short cvv,
            int billingZip,
            short pin,
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

    public PersonalCard(long id,
                        long userId,
                        long accountId,
                        String cardholderName,
                        long cardNumber,
                        String cardType,
                        short expDate,
                        short cvv,
                        int billingZip,
                        short pin,
                        String cardName) {
        this.id = id;
        this.userId = userId;
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
    public long getUserId() { return userId; }
    public String getCardName() { return cardName; }

    // --- Setters
    public void setId(long id) { this.id = id; }
    public void setAccountId(long accountId) { this.accountId = accountId; }
    public void setCardholderName(String cardholderName) { this.cardholderName = cardholderName; }
    public void setCardNumber(long cardNumber) { this.cardNumber = cardNumber; }
    public void setCardType(String cardType) { this.cardType = cardType; }
    public void setExpDate(short expDate) { this.expDate = expDate; }
    public void setCvv(short cvv) { this.cvv = cvv; }
    public void setBillingZip(int billingZip) { this.billingZip = billingZip; }
    public void setPin(short pin) { this.pin = pin; }
    public void setUserId(long userId) { this.userId = userId; }
    public void setCardName(String cardName) { this.cardName = cardName; }
}
