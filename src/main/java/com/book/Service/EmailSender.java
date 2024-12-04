package com.book.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.book.Repository.Mailrepository;
import com.book.entity.Mailentity;

@Service
public class EmailSender {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Mailrepository mailRepository; 

   
    public void sendEmail(Mailentity mailEntity) {
      
        if (mailEntity.getRecipient() == null || mailEntity.getRecipient().isBlank()) {
            throw new IllegalArgumentException("Recipient email address cannot be null or empty");
        }
        if (mailEntity.getSubject() == null || mailEntity.getSubject().isBlank()) {
            throw new IllegalArgumentException("Email subject cannot be null or empty");
        }
        if (mailEntity.getBody() == null || mailEntity.getBody().isBlank()) {
            throw new IllegalArgumentException("Email body cannot be null or empty");
        }

       
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailEntity.getRecipient());
        message.setSubject(mailEntity.getSubject());
        message.setText(mailEntity.getBody());
        message.setFrom("samjoshuacs2002@gmail.com");
        try {
           
            mailSender.send(message);
            System.out.println("Message sent successfully to " + mailEntity.getRecipient());

           
            mailRepository.save(mailEntity); 
            System.out.println("Email information saved in the database.");
        } catch (Exception e) {
            System.err.println("Error sending email: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
