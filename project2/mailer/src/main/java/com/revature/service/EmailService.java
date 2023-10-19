package com.revature.service;

import com.revature.entity.EmailDetails;

public interface EmailService {
    String sendMail(EmailDetails details);
}
