package com.revature.service;

import com.revature.daos.LoanDAO;
import com.revature.models.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllLoansService {

    private final LoanDAO loanDAO;

    @Autowired
    public GetAllLoansService(LoanDAO loanDAO) {
        this.loanDAO = loanDAO;
    }

    public List<Loan> getAllLoans() {
        return loanDAO.findAll();
    }
}
