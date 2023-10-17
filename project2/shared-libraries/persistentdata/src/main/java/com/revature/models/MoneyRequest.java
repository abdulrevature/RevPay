package com.revature.models;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "money_request")
@Component
public class MoneyRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long request_id;


    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User to_user_id;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User from_user_id;

    @Column(nullable = false)
    private int request_amount;

    @Column(nullable = false)
    private String request_status;


    public MoneyRequest() {

    }

    public MoneyRequest(long request_id, User to_user_id, User from_user_id, int request_amount,
                        String request_status) {
        this.request_id = request_id;
        this.to_user_id = to_user_id;
        this.from_user_id = from_user_id;
        this.request_amount = request_amount;
        this.request_status = request_status;
    }

    public MoneyRequest(long request_id, User to_user_id, User from_user_id, int request_amount) {
        this.request_id = request_id;
        this.to_user_id = to_user_id;
        this.from_user_id = from_user_id;
        this.request_amount = request_amount;
    }


    public long getRequest_id() {
        return request_id;
    }

    public void setRequest_id(long request_id) {
        this.request_id = request_id;
    }

    public User getTo_user_id() {
        return to_user_id;
    }

    public void setTo_user_id(User to_user_id) {
        this.to_user_id = to_user_id;
    }

    public User getFrom_user_id() {
        return from_user_id;
    }

    public void setFrom_user_id(User from_user_id) {
        this.from_user_id = from_user_id;
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

    @Override
    public String toString() {
        return "com.revature.models.MoneyRequest [request_id=" + request_id + ", to_user_id=" + to_user_id + ", from_user_id="
                + from_user_id + ", request_amount=" + request_amount + ", request_status=" + request_status + "]";
    }


}
