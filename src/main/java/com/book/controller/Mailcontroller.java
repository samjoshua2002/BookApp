package com.book.controller;

import com.book.Service.EmailSender;
import com.book.entity.Mailentity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/email")
public class Mailcontroller {

    @Autowired
    private EmailSender emailSender;

 
    @PostMapping("/send")
    public String sendEmail(@RequestBody Mailentity mailEntity) {
        try {
           
            emailSender.sendEmail(mailEntity);

            return "Email sent successfully and saved to database!";
        } catch (Exception e) {
           
            return "Error sending email: " + e.getMessage();
        }
    }
}
