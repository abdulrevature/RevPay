package com.revature.models;

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
    @OneToOne
    private MoneyRequest moneyRequest;

    private String description;

    private LocalDateTime dateTime;

    private int amount;

    @ManyToOne
    @JoinColumn(name = "to_user_id")
    private User toUser;

    @ManyToOne
    @JoinColumn(name = "from_user_id")
    private User fromUser;

    public Transaction(long id, MoneyRequest moneyRequest, String description, int amount, User toUser, User fromUser) {
        this.id = id;
        this.moneyRequest = moneyRequest;
        this.description = description;
        this.amount = amount;
        this.toUser = toUser;
        this.fromUser = fromUser;
    }

    public Transaction(MoneyRequest moneyRequest, String description, int amount, User toUser, User fromUser) {
        this.moneyRequest = moneyRequest;
        this.description = description;
        this.amount = amount;
        this.toUser = toUser;
        this.fromUser = fromUser;
    }

    public Transaction(String description, int amount, User toUser, User fromUser) {
        this.description = description;
        this.amount = amount;
        this.toUser = toUser;
        this.fromUser = fromUser;
    }

    public Transaction(long id, String description, int amount, User toUser, User fromUser) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.toUser = toUser;
        this.fromUser = fromUser;
    }

    public Transaction() {
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
