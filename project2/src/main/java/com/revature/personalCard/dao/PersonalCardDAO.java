package com.revature.personalcard.dao;

import com.revature.businesscard.model.BusinessCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalCardDAO extends JpaRepository<BusinessCard, Integer> {
}
