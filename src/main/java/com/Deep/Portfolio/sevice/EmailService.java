package com.Deep.Portfolio.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendContactMail(String name, String email, String phone, String message){

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo("yt9889712@gmail.com");
        mail.setSubject("New Contact form submission from " + name);

        mail.setReplyTo(email);

        mail.setText(
                "You have received a new message from your portfolio:\n\n" +
                        "Name: " + name + "\n" +
                        "Email: " + email + "\n" +
                        "Phone: " + phone + "\n\n" +
                        "Message:\n" + message
        );

        mailSender.send(mail);
    }

}
