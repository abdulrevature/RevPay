package com.revature.sharedLibraries.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "payment")
@Component
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentId;

    @Column(nullable = false)
    private double paymentAmount;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business businessId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    public Payment() {
    }

    public Payment(double paymentAmount, Business businessId, User userId) {
        this.paymentAmount = paymentAmount;
        this.businessId = businessId;
        this.userId = userId;
    }

    public Payment(long paymentId, double paymentAmount, Business businessId, User userId) {
        this.paymentId = paymentId;
        this.paymentAmount = paymentAmount;
        this.businessId = businessId;
        this.userId = userId;
    }

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Business getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Business businessId) {
        this.businessId = businessId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", paymentAmount=" + paymentAmount +
                ", businessId=" + businessId +
                ", userId=" + userId +
                '}';
    }
}
