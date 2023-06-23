package com.bitirmetezi.prometheusjava.service.mailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmailOnAlert(MailServiceInput serviceInput) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("pmalertmanager@gmail.com");
        message.setTo(serviceInput.getTo());
        message.setSubject(serviceInput.getSubject());
        message.setText(serviceInput.getBody());

        mailSender.send(message);
    }
}
