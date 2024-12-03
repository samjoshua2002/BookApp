package com.book;


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
    private Mailrepository mailRepository; // Inject MailRepository to save emails

    // Method to send email and store email info in the database
    public void sendEmail(Mailentity mailEntity) {
        // Validate fields in the MailEntity
        if (mailEntity.getRecipient() == null || mailEntity.getRecipient().isBlank()) {
            throw new IllegalArgumentException("Recipient email address cannot be null or empty");
        }
        if (mailEntity.getSubject() == null || mailEntity.getSubject().isBlank()) {
            throw new IllegalArgumentException("Email subject cannot be null or empty");
        }
        if (mailEntity.getBody() == null || mailEntity.getBody().isBlank()) {
            throw new IllegalArgumentException("Email body cannot be null or empty");
        }

        // Create SimpleMailMessage to send the email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailEntity.getRecipient());
        message.setSubject(mailEntity.getSubject());
        message.setText(mailEntity.getBody());
        message.setFrom("samjoshuacs2002@gmail.com"); // Use a fixed sender email

        try {
            // Send the email
            mailSender.send(message);
            System.out.println("Message sent successfully to " + mailEntity.getRecipient());

            // Save the email information in the database
            mailRepository.save(mailEntity);  // Save the email to DB after sending
            System.out.println("Email information saved in the database.");
        } catch (Exception e) {
            System.err.println("Error sending email: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
