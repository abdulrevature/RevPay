package com.revature.dtos;

public class PersonalCardDTO {
    private String cardType;
    private long cardNumber;
    private String firstName;
    private String lastName;
    private String cardHolderName;
    private short cvv;
    private short pin;
    private short expDate;
    private int billingZip;

    public PersonalCardDTO() {}

    public PersonalCardDTO(String cardHolderName,
                           String cardType,
                           long cardNumber,
                           short pin,
                           short cvv,
                           int billingZip,
                           short expDate) {
        this.cardHolderName = cardHolderName;
        this.cardType       = cardType;
        this.cardNumber     = cardNumber;
        this.pin            = pin;
        this.cvv            = cvv;
        this.billingZip     = billingZip;
        this.expDate        = expDate;
    }

    public String getCardType() { return cardType; }
    public long getCardNumber() { return cardNumber; }
    public String getCardHolderName() { return cardHolderName;  }
    public short getCvv() { return cvv; }
    public int getBillingZip() { return billingZip; }
    public short getExpDate() { return expDate; }
    public short getPin() { return pin; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    public void setCardType(String cardType) { this.cardType = cardType; }
    public void setCardNumber(long cardNumber) { this.cardNumber = cardNumber; }
    public void setCardHolderName(String cardHolderName) { this.cardHolderName = cardHolderName; }
    public void setCvv(short cvv) { this.cvv = cvv; }
    public void setBillingZip(int billingZip) { this.billingZip = billingZip; }
    public void setExpDate(short expDate) { this.expDate = expDate; }
    public void setPin(short pin) { this.pin = pin; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
}
