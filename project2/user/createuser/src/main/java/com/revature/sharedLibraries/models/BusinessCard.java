package com.revature.sharedLibraries.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "business_card")
@Component
public class BusinessCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long businessCardId;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business businessId;

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

    public BusinessCard() {
    }

    public BusinessCard(long id) {
        this.businessCardId = id;
    }

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
            Business businessId,
            String cardholderName,
            long cardNumber,
            String cardType,
            int expDate,
            int cvv,
            int billingZip,
            int pin,
            String cardName
    ) {
        this.businessCardId = id;
        this.businessId = businessId;
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
    public long getId() {
        return businessCardId;
    }

    public Business getAccountId() {
        return businessId;
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

    public String getCardName() {
        return cardName;
    }

    // --- Setters

    public void setId(long id) {
        this.businessCardId = id;
    }

    public void setAccountId(Business businessId) {
        this.businessId = businessId;
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

    public void setExpDate(int expDate) {
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

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    @Override
    public String toString() {
        return "BusinessCard{" +
                "businessCardId=" + businessCardId +
                ", businessId=" + businessId +
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
