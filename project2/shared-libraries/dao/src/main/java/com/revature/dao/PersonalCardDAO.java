package com.revature.dao;

import com.revature.model.BusinessCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalCardDAO extends JpaRepository<BusinessCard, Integer> {
}
