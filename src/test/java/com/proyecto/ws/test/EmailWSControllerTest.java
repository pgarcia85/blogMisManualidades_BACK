package com.proyecto.ws.test;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailException;

import com.proyecto.request.EmailRequest;
import com.proyecto.request.UpdateComentarioRequest;
import com.proyecto.service.EmailService;
import com.proyecto.ws.EmailWSController;

@SpringBootTest
public class EmailWSControllerTest {
	
	@InjectMocks
	EmailWSController emailController;
	
	@Mock
	EmailService emailService;
	
	@Before
	public void inicio() {
	   MockitoAnnotations.initMocks(this);   
	 }

	@Test
	public void enviarEmailTest(){
		EmailRequest emailRequest = Mockito.mock(EmailRequest.class, Mockito.RETURNS_DEEP_STUBS);
		Assertions.assertEquals(200, emailController.enviarEmail(emailRequest).getStatusCodeValue());
	}
	

}
