package com.revature.sharedLibraries.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "personal_card")
@Component
public class PersonalCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personalCardId;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    private User userId;

    @Column(nullable = false, unique = true)
    private String cardholderName;

    @Column(nullable = false, unique = true)
    private long cardNumber;

    @Column(nullable = false)
    private String cardType;

    @Column(nullable = false)
    private int expDate;

    @Column(nullable = false)
    private int cvv;

    @Column(nullable = false)
    private int billingZip;

    @Column(nullable = false)
    private int pin;

    @Column(nullable = false)
    private String cardName;

    public PersonalCard() {
    }

    public PersonalCard(long id) {
        this.personalCardId = id;
    }

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
            String cardholderName,
            long cardNumber,
            String cardType,
            short expDate,
            int cvv,
            int billingZip,
            int pin,
            String cardName
    ) {
        this.personalCardId = id;
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
                        String cardholderName,
                        long cardNumber,
                        String cardType,
                        short expDate,
                        int cvv,
                        int billingZip,
                        int pin,
                        String cardName) {
        this.personalCardId = id;
        this.userId = userId;
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
    public long getId() {
        return personalCardId;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public int getExpDate() {
        return expDate;
    }

    public int getCvv() {
        return cvv;
    }

    public int getBillingZip() {
        return billingZip;
    }

    public int getPin() {
        return pin;
    }

    public User getUserId() {
        return userId;
    }

    public String getCardName() {
        return cardName;
    }

    // --- Setters
    public void setId(long id) {
        this.personalCardId = id;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setExpDate(short expDate) {
        this.expDate = expDate;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setBillingZip(int billingZip) {
        this.billingZip = billingZip;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    @Override
    public String toString() {
        return "PersonalCard{" +
                "personalCardId=" + personalCardId +
                ", userId=" + userId +
                ", cardholderName='" + cardholderName + '\'' +
                ", cardNumber=" + cardNumber +
                ", cardType='" + cardType + '\'' +
                ", expDate=" + expDate +
                ", cvv=" + cvv +
                ", billingZip=" + billingZip +
                ", pin=" + pin +
                ", cardName='" + cardName + '\'' +
                '}';
    }
}
