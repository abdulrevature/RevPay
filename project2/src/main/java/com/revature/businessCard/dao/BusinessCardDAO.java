package com.revature.businessCard.dao;

import com.revature.businessCard.model.BusinessCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessCardDAO extends JpaRepository<BusinessCard, Integer> {

}
