package com.revature.businesscard.service;

public class BusinessCardNotFoundException extends RuntimeException {
    public BusinessCardNotFoundException(long id) {
        super("Business Card not found with ID: " + id);
    }
}

