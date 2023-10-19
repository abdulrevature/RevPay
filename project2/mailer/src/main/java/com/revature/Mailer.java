package com.revature;

import com.revature.entity.EmailDetails;
import com.revature.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.function.context.FunctionalSpringApplication;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootConfiguration
public class Mailer {
    public static void main(String[] args) {
        FunctionalSpringApplication.run(Mailer.class, args);

    }

    private EmailService emailService;

    @Autowired
    public String send(EmailService emailService, @RequestBody EmailDetails details) {
        this.emailService = emailService;
        String status = emailService.sendMail(details);

        return status;
    }

}