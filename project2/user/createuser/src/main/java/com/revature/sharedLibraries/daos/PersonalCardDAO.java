package com.revature.sharedLibraries.daos;

import com.revature.models.PersonalCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalCardDAO extends JpaRepository<PersonalCard, Integer> {
}
