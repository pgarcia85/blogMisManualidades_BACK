package com.proyecto.service;

public interface EmailService {
	
	void enviarEmail(String from, String to, String subject, String body);

}
