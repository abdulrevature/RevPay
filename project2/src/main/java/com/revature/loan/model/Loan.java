package com.revature.loan.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
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

    //    @ManyToMany
    //    @JoinColumn
    private long businessId;

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
    public Loan(BigDecimal loanBalance, boolean loanReviewed, boolean loanApproval, BigDecimal loanInterestRate, int loanTermLength, LocalDateTime loanRequestDateTime, long businessId) {
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
    public Loan(long loadId, BigDecimal loanBalance, boolean loanReviewed, boolean loanApproval, BigDecimal loanInterestRate, int loanTermLength, LocalDateTime loanRequestDateTime, long businessId) {
        this.loadId = loadId;
        this.loanBalance = loanBalance;
        this.loanReviewed = loanReviewed;
        this.loanApproval = loanApproval;
        this.loanInterestRate = loanInterestRate;
        this.loanTermLength = loanTermLength;
        this.loanRequestDateTime = loanRequestDateTime;
        this.businessId = businessId;
    }

}
