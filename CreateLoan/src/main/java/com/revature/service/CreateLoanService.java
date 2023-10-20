package com.revature.service;

import com.revature.daos.LoanDAO;
import com.revature.daos.BusinessDAO;
import com.revature.models.Loan;
import com.revature.models.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class CreateLoanService {

    private final LoanDAO loanDAO;
    private final BusinessDAO businessDAO;

    @Autowired
    public CreateLoanService(LoanDAO loanDAO, BusinessDAO businessDAO) {
        this.loanDAO = loanDAO;
        this.businessDAO = businessDAO;
    }

    public Loan createLoan(Loan loan, long businessId) {
        Optional<Business> business = businessDAO.findById(businessId);
        if (business.isEmpty()) {
            System.out.println(businessId);
            System.out.println(business.toString());
            throw new IllegalArgumentException("Business could not be found. Aborting Insert...");
        }
        Business gotBusiness = business.get();

        if (businessId <= 0) {
            throw new IllegalArgumentException("Business with an id of 0 or less cannot exist.");
        }
        if (loan.getLoanBalance().signum() != 1) {
            throw new IllegalArgumentException("Loan Request can not be $0.00 or less.");
        }

        loan.setBusinessId(gotBusiness);
        return loanDAO.save(loan);
    }
}
