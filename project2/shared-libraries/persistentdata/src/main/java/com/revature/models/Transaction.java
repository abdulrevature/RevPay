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



    public Transaction() {
        setDateTime();
    }

    public Transaction(long id, MoneyRequest moneyRequest, String description, LocalDateTime dateTime, int amount, User toUser, User fromUser) {
        this.id = id;
        this.moneyRequest = moneyRequest;
        this.description = description;
        this.dateTime = dateTime;
        this.amount = amount;
        this.toUser = toUser;
        this.fromUser = fromUser;
    }

    public Transaction(MoneyRequest moneyRequest, String description, LocalDateTime dateTime, int amount, User toUser, User fromUser) {
        this.moneyRequest = moneyRequest;
        this.description = description;
        this.dateTime = dateTime;
        this.amount = amount;
        this.toUser = toUser;
        this.fromUser = fromUser;
    }

    public Transaction(long id, String description, LocalDateTime dateTime, int amount, User toUser, User fromUser) {
        this.id = id;
        this.description = description;
        this.dateTime = dateTime;
        this.amount = amount;
        this.toUser = toUser;
        this.fromUser = fromUser;
    }

    public Transaction(String description, LocalDateTime dateTime, int amount, User toUser, User fromUser) {
        this.description = description;
        this.dateTime = dateTime;
        this.amount = amount;
        this.toUser = toUser;
        this.fromUser = fromUser;
    }

    public Transaction(long id, MoneyRequest moneyRequest, String description, int amount, User toUser, User fromUser) {
        this.id = id;
        this.moneyRequest = moneyRequest;
        this.description = description;
        this.amount = amount;
        this.toUser = toUser;
        this.fromUser = fromUser;
        setDateTime();
    }

    public Transaction(MoneyRequest moneyRequest, String description, int amount, User toUser, User fromUser) {
        this.moneyRequest = moneyRequest;
        this.description = description;
        this.amount = amount;
        this.toUser = toUser;
        this.fromUser = fromUser;
        setDateTime();
    }

    public Transaction(long id, String description, int amount, User toUser, User fromUser) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.toUser = toUser;
        this.fromUser = fromUser;
        setDateTime();
    }

    public Transaction(String description, int amount, User toUser, User fromUser) {
        this.description = description;
        this.amount = amount;
        this.toUser = toUser;
        this.fromUser = fromUser;
        setDateTime();
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

    public void setId(long id) {
        this.id = id;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", moneyRequest=" + moneyRequest +
                ", description='" + description + '\'' +
                ", dateTime=" + dateTime +
                ", amount=" + amount +
                ", toUser=" + toUser +
                ", fromUser=" + fromUser +
                '}';
    }
}
