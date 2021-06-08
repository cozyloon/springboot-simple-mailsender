package com.example.springemailclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SpringEmailClientApplication {

    @Autowired
    private EmailSenderService emailSenderService;

    public static void main(String[] args) {
        SpringApplication.run(SpringEmailClientApplication.class, args);
    }

    /*@EventListener(ApplicationReadyEvent.class)
    public void triggerMail()  {
        emailSenderService.sendSimpleEmail("cozyloon@gmail.com",
                "Hello this is springboot mail sender",
                "Springboot mail sender");

    }*/

    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail() throws MessagingException {
        emailSenderService.sentEmailWithAttachment("cozyloon@gmail.com",
                "Hello",
                "test msg",
                "C:\\Users\\DELL\\Desktop\\b.gif");
    }
}
