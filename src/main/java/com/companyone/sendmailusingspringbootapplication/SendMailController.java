package com.companyone.sendmailusingspringbootapplication;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class SendMailController {

    @Autowired
    SendMailUsingSpringBootApplication sendMailUsingSpringBootApplication;

    @RequestMapping(value = "/sendmail")
    public String send() throws AddressException, MessagingException, IOException{

        sendMailUsingSpringBootApplication.sendEmailWithAttachment();   
        return "Email send successfully!";
    }
}
