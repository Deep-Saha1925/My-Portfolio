package com.Deep.Portfolio.controller;

import com.Deep.Portfolio.dto.ContactDto;
import com.Deep.Portfolio.sevice.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-message")
    public String sendMessage(@RequestBody ContactDto contactDto) {

        emailService.sendContactMail(
                contactDto.getName(),
                contactDto.getEmail(),
                contactDto.getPhone(),
                contactDto.getMessage()
        );

        return "success";
    }

}
