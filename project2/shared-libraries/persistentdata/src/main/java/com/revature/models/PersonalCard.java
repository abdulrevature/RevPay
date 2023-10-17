package com.revature.models;

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

    @JoinColumn(name="userId", nullable = true)
    @ManyToOne
    private User userId;
    @JoinColumn(name="accountId", nullable = true)
    @ManyToOne private Account accountId;

    @Column private String cardholderName;
    @Column private long cardNumber;
    @Column private String cardType;
    @Column private short expDate;
    @Column private int cvv;
    @Column private int billingZip;
    @Column private int pin;
    @Column private String cardName;

    // Constructors
    public PersonalCard() {}

    public PersonalCard(long id) { this.id = id; }

    public PersonalCard(long cardNumber, short expDate, int cvv, int billingZip) {
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.cvv = cvv;
        this.billingZip = billingZip;
    }

    public PersonalCard(String cardholderName, long cardNumber, short expDate, int cvv, int billingZip) {
        this.cardholderName = cardholderName;
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.cvv = cvv;
        this.billingZip = billingZip;
    }

    public PersonalCard(
            long id,
            Account accountId,
            String cardholderName,
            long cardNumber,
            String cardType,
            short expDate,
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

    public PersonalCard(long id,
                        User userId,
                        Account accountId,
                        String cardholderName,
                        long cardNumber,
                        String cardType,
                        short expDate,
                        int cvv,
                        int billingZip,
                        int pin,
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
    public Account getAccountId() { return accountId; }
    public String getCardholderName() { return cardholderName; }
    public long getCardNumber() { return cardNumber; }
    public String getCardType() { return cardType; }
    public int getExpDate() { return expDate; }
    public int getCvv() { return cvv; }
    public int getBillingZip() { return billingZip; }
    public int getPin() { return pin; }
    public User getUserId() { return userId; }
    public String getCardName() { return cardName; }

    // --- Setters
    public void setId(long id) { this.id = id; }
    public void setAccountId(Account accountId) { this.accountId = accountId; }
    public void setCardholderName(String cardholderName) { this.cardholderName = cardholderName; }
    public void setCardNumber(long cardNumber) { this.cardNumber = cardNumber; }
    public void setCardType(String cardType) { this.cardType = cardType; }
    public void setExpDate(short expDate) { this.expDate = expDate; }
    public void setCvv(int cvv) { this.cvv = cvv; }
    public void setBillingZip(int billingZip) { this.billingZip = billingZip; }
    public void setPin(int pin) { this.pin = pin; }
    public void setUserId(User userId) { this.userId = userId; }
    public void setCardName(String cardName) { this.cardName = cardName; }
}
