<<<<<<<< HEAD:project2/shared-libraries/persistentdata/src/main/java/com/revature/daos/BusinessCardDAO.java
package com.revature.daos;

import com.revature.models.BusinessCard;
========
package com.revature.dao;

import com.revature.model.BusinessCard;
>>>>>>>> main:project2/shared-libraries/dao/src/main/java/com/revature/dao/BusinessCardDAO.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessCardDAO extends JpaRepository<BusinessCard, Integer> {

}
