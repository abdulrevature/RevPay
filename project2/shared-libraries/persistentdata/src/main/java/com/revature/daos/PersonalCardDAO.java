package com.revature.daos;

import com.revature.models.PersonalCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalCardDAO extends JpaRepository<PersonalCard, Integer> {
}
