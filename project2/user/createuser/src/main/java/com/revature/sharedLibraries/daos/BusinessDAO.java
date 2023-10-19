package com.revature.sharedLibraries.daos;

import com.revature.sharedLibraries.models.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BusinessDAO extends JpaRepository<Business, Long> {
}
