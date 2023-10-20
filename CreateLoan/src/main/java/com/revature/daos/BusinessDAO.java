package com.revature.daos;

import com.revature.models.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessDAO extends JpaRepository<Business, Long> {
}