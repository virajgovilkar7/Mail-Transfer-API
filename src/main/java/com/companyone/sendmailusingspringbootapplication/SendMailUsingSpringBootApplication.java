package com.companyone.sendmailusingspringbootapplication;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class SendMailUsingSpringBootApplication {

	@Autowired
	private JavaMailSender javaMailSender;

	public static void main(String[] args) {
		SpringApplication.run(SendMailUsingSpringBootApplication.class, args);
	}

	void sendEmail(){
		SimpleMailMessage msg = new SimpleMailMessage();

		msg.setTo(("virajgovilkar7@gmail.com"));

		msg.setSubject("Testing from Spring Boot");
		msg.setText("HELLO from SPRING BOOT");

		javaMailSender.send(msg);
	}

	void sendEmailWithAttachment() throws MessagingException, IOException{

		MimeMessage msg = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(msg, true);

		helper.setTo("virajgovilkar7@gmail.com");
		helper.setSubject("Testing from Spring Boot");

		helper.setText("<h1>Check attachment for email</h1>", true);

		FileSystemResource file = new FileSystemResource(new File("C:/Users...."));

		helper.addAttachment("filename", file);

		javaMailSender.send(msg);
	}
}