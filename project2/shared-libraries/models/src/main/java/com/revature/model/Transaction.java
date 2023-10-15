package com.revature.model;

import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Component
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JoinColumn(name = "money_request_id")
    private MoneyRequest moneyRequest;
    private String description;
    private LocalDateTime dateTime;
    private int amount;
    private String memo;

    public Transaction(MoneyRequest moneyRequest, String description, int amount, String memo) {
        this.moneyRequest = moneyRequest;
        this.description = description;
        this.amount = amount;
        this.memo = memo;
    }


    public MoneyRequest getMoneyRequest() {
        return moneyRequest;
    }

    public void setMoneyRequest(MoneyRequest moneyRequest) {
        this.moneyRequest = moneyRequest;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    private void setDateTime() {
        dateTime = LocalDateTime.now();
    }
}
