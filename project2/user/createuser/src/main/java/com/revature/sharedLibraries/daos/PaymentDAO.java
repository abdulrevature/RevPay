package com.revature.sharedLibraries.daos;

import com.revature.sharedLibraries.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDAO extends JpaRepository<Payment, Long> {
}
