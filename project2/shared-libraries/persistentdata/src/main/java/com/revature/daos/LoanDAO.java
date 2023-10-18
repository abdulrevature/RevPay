package com.revature.daos;

import com.revature.models.BusinessCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanDAO extends JpaRepository<BusinessCard, Long> {
}