package com.example.stagecochess.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendApprovalEmail(String to, String appointmentDate, String appointmentStartTime) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Appointment Approved");
        message.setText("Your appointment scheduled on " + appointmentDate +
                " at " + appointmentStartTime + " has been approved.");
        emailSender.send(message);
    }
}

