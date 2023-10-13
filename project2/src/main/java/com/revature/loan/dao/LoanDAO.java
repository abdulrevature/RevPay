package com.revature.loan.dao;

import com.revature.loan.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanDAO extends JpaRepository<Loan, Integer> {
}
