package com.revature.mailer;

import com.revature.mailer.entity.Email;
import com.revature.mailer.service.MailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class Mailer {
    public static void main(String[] args) {
        SpringApplication.run(Mailer.class, args);
    }

    @Autowired
    private MailerService mailerService;

    @Bean
    public Consumer<Email> send() {
        return email -> mailerService.send(email.getRecipient(), email.getSubject(), email.getMessage());
    }
}