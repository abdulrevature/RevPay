package com.revature.loan.service;

import com.revature.loan.model.Loan;
import com.revature.loan.dao.LoanDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    private final LoanDAO loanDAO;

    @Autowired
    public LoanService(LoanDAO loanDAO) {
        this.loanDAO = loanDAO;
    }

    public List<Loan> getAllLoans() {
        return loanDAO.findAll();
    }

    public Loan getLoanById(int loanId) {
        if (loanId <= 0) {
            throw new IllegalArgumentException("Loans with an id of 0 or less cannot exist.");
        }
        Optional<Loan> loan = loanDAO.findById(loanId);
        if (loan.isEmpty()) {
            throw new IllegalArgumentException("Loans with an id of " + loanId + " does not exist.");
        }
        return loan.get();
    }

    public Loan updateLoanIsApprovedById(int loanId, boolean isApproved) {
        if (loanId <= 0) {
            throw new IllegalArgumentException("Loans with an id of 0 or less cannot exist.");
        }
        Optional<Loan> oldLoan = loanDAO.findById(loanId);
        if (oldLoan.isEmpty()) {
            throw new IllegalArgumentException("Loan with ID of " + loanId + " does not exist.");
        } else {
            Loan newLoan = oldLoan.get();
            newLoan.setLoanApproval(isApproved);
            newLoan.setLoanReviewed(true);
            return loanDAO.save(newLoan); //perform the update
        }
    }

}
