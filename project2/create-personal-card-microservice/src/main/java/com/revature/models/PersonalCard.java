package com.revature.models;

import javax.persistence.*;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;



@Entity
@Table
@Component
public class PersonalCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "userId", nullable = true)
    @ManyToOne
    private User userId;

    @JoinColumn(name = "accountId", nullable = true)
    @ManyToOne
    private Account accountId;

    @Column private String cardholderName;
    @Column private long cardNumber;
    @Column private String cardType;
    @Column private short expDate;
    @Column private short pin;
    @Column short cvv;
    @Column private int billingZip;
    @Column private String cardName;

    public PersonalCard() {}

    public PersonalCard(final String cardholderName,
                        final String cardType,
                        final long cardNumber,
                        final short pin,
                        final short cvv,
                        final int billingZip,
                        final short expDate) {
        this.cardholderName = cardholderName;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.cvv = cvv;
        this.billingZip = billingZip;
        this.expDate = expDate;
    }

    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public User getUserId() {
        return this.userId;
    }

    public void setUserId(final User userId) {
        this.userId = userId;
    }

    public Account getAccountId() {
        return this.accountId;
    }

    public void setAccountId(final Account accountId) {
        this.accountId = accountId;
    }

    public String getCardholderName() {
        return this.cardholderName;
    }

    public void setCardholderName(final String cardHolderName) {
        this.cardholderName = cardHolderName;
    }

    public long getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(final long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return this.cardType;
    }

    public void setCardType(final String cardType) {
        this.cardType = cardType;
    }

    public short getExpDate() {
        return this.expDate;
    }

    public void setExpDate(final short expDate) {
        this.expDate = expDate;
    }

    public short getCvv() {
        return this.cvv;
    }

    public void setCvv(final short cvv) {
        this.cvv = cvv;
    }

    public int getBillingZip() {
        return this.billingZip;
    }

    public void setBillingZip(final int billingZip) {
        this.billingZip = billingZip;
    }

    public String getCardName() {
        return this.cardName;
    }

    public void setCardName(final String cardName) {
        this.cardName = cardName;
    }

    public short getPin() {
        return this.pin;
    }

    public void setPin(final short pin) {
        this.pin = pin;
    }
}
