package com.proyecto.service.test;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;

import com.proyecto.service.EmailServiceImpl;

@SpringBootTest
public class EmailServiceImplTest {
	
	@InjectMocks
	EmailServiceImpl emailServiceImpl;
	 
	@Mock
	JavaMailSender javaMailSender;
	
	@Before
	public void inicio() {
	   MockitoAnnotations.initMocks(this);   
	 }

	@Test
	void enviarEmail(){
		emailServiceImpl.enviarEmail("from", "to", "subject", "texto");
	}
	

}
