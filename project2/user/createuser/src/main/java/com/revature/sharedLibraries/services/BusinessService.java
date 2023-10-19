package com.revature.sharedLibraries.services;

import com.revature.sharedLibraries.daos.BusinessCardDAO;
import com.revature.sharedLibraries.daos.BusinessDAO;
import com.revature.sharedLibraries.daos.PaymentDAO;
import com.revature.sharedLibraries.models.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BusinessService {
    @Autowired
    private BusinessDAO businessDAO;

    public Business save(Business b) {
        return businessDAO.save(b);
    }

    public Business getById(Long id) {
        return businessDAO.getReferenceById(id);
    }

    public List<Business> getAll() {
        return businessDAO.findAll();
    }
}
