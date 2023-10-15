package com.revature.daos;

import com.revature.model.BusinessCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessCardDAO extends JpaRepository<BusinessCard, Integer> {

}
