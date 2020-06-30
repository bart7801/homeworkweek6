package com.bart.homeworkweek6.service;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class EmailService {

    @Value("${email.to.send}")
    private String emailToSend;
    private JavaMailSender javaMailSender;

    public EmailService() {
    }

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @After("@annotation(SendEmail)")
    void emailCreate() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(emailToSend);         // recipient's email, set in application.properties
        msg.setSubject("A NEW  MOVIE HAS BEEN ADDED TO OUR LIST.");
        msg.setText("HELLO! \n \n We inform You that we have added a new movie. \n\n" + "http://localhost:8080//movieListApi");
        javaMailSender.send(msg);
    }
}
