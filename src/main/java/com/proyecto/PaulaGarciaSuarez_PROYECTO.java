package com.proyecto;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PaulaGarciaSuarez_PROYECTO extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(PaulaGarciaSuarez_PROYECTO.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(PaulaGarciaSuarez_PROYECTO.class, args);
	}

}
