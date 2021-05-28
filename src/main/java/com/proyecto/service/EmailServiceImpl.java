package com.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{

	@Autowired
	private JavaMailSender javaMailSender;
	
	
	@Override
	public void enviarEmail(String from, String to, String subject, String texto) {
		
		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom(from);
		email.setTo(to);
		email.setSubject(subject);
		email.setText(texto);
		
		javaMailSender.send(email);
	}

	
	
}
