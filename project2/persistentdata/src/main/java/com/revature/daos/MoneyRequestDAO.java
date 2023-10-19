package com.revature.daos;

import com.revature.models.BusinessCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyRequestDAO extends JpaRepository<BusinessCard, Long> {
}
