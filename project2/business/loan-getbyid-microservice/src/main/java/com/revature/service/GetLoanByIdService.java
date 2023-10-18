package com.revature.service;

import com.revature.daos.LoanDAO;
import com.revature.models.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetLoanByIdService {

    private final LoanDAO loanDAO;

    @Autowired
    public GetLoanByIdService(LoanDAO loanDAO) {
        this.loanDAO = loanDAO;
    }

    public Optional<Loan> getLoanById(long loanId) {
        return loanDAO.findById(loanId);
    }
}
