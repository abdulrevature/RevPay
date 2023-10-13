package com.revature.account.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "business")
@Component
public class Account {
    //NOTE: "Account" represents "Business" in the ERD

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long businessId;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private double balance;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    public Account(long businessId, String name, double balance, String email, String username, String password) {
        this.businessId = businessId;
        this.name = name;
        this.balance = balance;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Account(String name, double balance, String email, String username, String password) {
        this.name = name;
        this.balance = balance;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "businessId=" + businessId +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
