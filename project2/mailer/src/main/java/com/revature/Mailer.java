package com.revature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionalSpringApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Import(MailerConfiguration.class)
@SpringBootApplication
@RestController
public class Mailer {
    public static void main(String[] args) {
        SpringApplication.run(Mailer.class, args);
    }

    private EmailService emailService;

    public Mailer(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/sendmail")
    public String send(EmailService emailService, @RequestBody EmailDetails details) {
        this.emailService = emailService;
        String status = emailService.sendMail(details);

        return status;
    }

}