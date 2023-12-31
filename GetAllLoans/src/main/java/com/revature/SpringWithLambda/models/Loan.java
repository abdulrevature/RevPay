package com.revature.SpringWithLambda.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Component
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loadId;

    @Column(nullable = false)
    private BigDecimal loanBalance;

    @Column(nullable = false)
    private boolean loanReviewed;

    @Column(nullable = false)
    private boolean loanApproval;

    @Column(nullable = false)
    private BigDecimal loanInterestRate;

    @Column(nullable = false)
    private int loanTermLength;

    @Column(nullable = false)
    private LocalDateTime loanRequestDateTime;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business businessId;

    // Base constructor. (loan always starts without approval and without review)
    public Loan() {
        this.loanApproval = false;
        this.loanReviewed = false;
    }

    // Constructor with no IDs
    public Loan(BigDecimal loanBalance, boolean loanReviewed, boolean loanApproval, BigDecimal loanInterestRate, int loanTermLength, LocalDateTime loanRequestDateTime) {
        this.loanBalance = loanBalance;
        this.loanReviewed = loanReviewed;
        this.loanApproval = loanApproval;
        this.loanInterestRate = loanInterestRate;
        this.loanTermLength = loanTermLength;
        this.loanRequestDateTime = loanRequestDateTime;
    }

    // Constructor with no loan ID
    public Loan(BigDecimal loanBalance, boolean loanReviewed, boolean loanApproval, BigDecimal loanInterestRate, int loanTermLength, LocalDateTime loanRequestDateTime, Business businessId) {
        this.loanBalance = loanBalance;
        this.loanReviewed = loanReviewed;
        this.loanApproval = loanApproval;
        this.loanInterestRate = loanInterestRate;
        this.loanTermLength = loanTermLength;
        this.loanRequestDateTime = loanRequestDateTime;
        this.businessId = businessId;
    }

    // Constructor with no business ID
    public Loan(long loadId, BigDecimal loanBalance, boolean loanReviewed, boolean loanApproval, BigDecimal loanInterestRate, int loanTermLength, LocalDateTime loanRequestDateTime) {
        this.loadId = loadId;
        this.loanBalance = loanBalance;
        this.loanReviewed = loanReviewed;
        this.loanApproval = loanApproval;
        this.loanInterestRate = loanInterestRate;
        this.loanTermLength = loanTermLength;
        this.loanRequestDateTime = loanRequestDateTime;
    }

    // Constructor with everything
    public Loan(long loadId, BigDecimal loanBalance, boolean loanReviewed, boolean loanApproval, BigDecimal loanInterestRate, int loanTermLength, LocalDateTime loanRequestDateTime, Business businessId) {
        this.loadId = loadId;
        this.loanBalance = loanBalance;
        this.loanReviewed = loanReviewed;
        this.loanApproval = loanApproval;
        this.loanInterestRate = loanInterestRate;
        this.loanTermLength = loanTermLength;
        this.loanRequestDateTime = loanRequestDateTime;
        this.businessId = businessId;
    }

    public long getLoadId() {
        return loadId;
    }

    public void setLoadId(long loadId) {
        this.loadId = loadId;
    }

    public BigDecimal getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(BigDecimal loanBalance) {
        this.loanBalance = loanBalance;
    }

    public boolean isLoanReviewed() {
        return loanReviewed;
    }

    public void setLoanReviewed(boolean loanReviewed) {
        this.loanReviewed = loanReviewed;
    }

    public boolean isLoanApproval() {
        return loanApproval;
    }

    public void setLoanApproval(boolean loanApproval) {
        this.loanApproval = loanApproval;
    }

    public BigDecimal getLoanInterestRate() {
        return loanInterestRate;
    }

    public void setLoanInterestRate(BigDecimal loanInterestRate) {
        this.loanInterestRate = loanInterestRate;
    }

    public int getLoanTermLength() {
        return loanTermLength;
    }

    public void setLoanTermLength(int loanTermLength) {
        this.loanTermLength = loanTermLength;
    }

    public LocalDateTime getLoanRequestDateTime() {
        return loanRequestDateTime;
    }

    public void setLoanRequestDateTime(LocalDateTime loanRequestDateTime) {
        this.loanRequestDateTime = loanRequestDateTime;
    }

    public Business getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Business businessId) {
        this.businessId = businessId;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loadId=" + loadId +
                ", loanBalance=" + loanBalance +
                ", loanReviewed=" + loanReviewed +
                ", loanApproval=" + loanApproval +
                ", loanInterestRate=" + loanInterestRate +
                ", loanTermLength=" + loanTermLength +
                ", loanRequestDateTime=" + loanRequestDateTime +
                ", businessId=" + businessId +
                '}';
    }
}
