package com.revature.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "money_request")
@Component
public class MoneyRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long requestId;

    @ManyToOne
    @JoinColumn(name = "to_user_id")
    private User toUser;

    @ManyToOne
    @JoinColumn(name = "from_user_id")
    private User fromUser;

    @Column(nullable = false)
    private int request_amount;

    @Column(nullable = false)
    private String request_status;

    public MoneyRequest() {
    }

    public MoneyRequest(long requestId, User toUser, User fromUser, int request_amount, String request_status) {
        this.requestId = requestId;
        this.toUser = toUser;
        this.fromUser = fromUser;
        this.request_amount = request_amount;
        this.request_status = request_status;
    }

    public MoneyRequest(User toUser, User fromUser, int request_amount, String request_status) {
        this.toUser = toUser;
        this.fromUser = fromUser;
        this.request_amount = request_amount;
        this.request_status = request_status;
    }


    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public int getRequest_amount() {
        return request_amount;
    }

    public void setRequest_amount(int request_amount) {
        this.request_amount = request_amount;
    }

    public String getRequest_status() {
        return request_status;
    }

    public void setRequest_status(String request_status) {
        this.request_status = request_status;
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
}
