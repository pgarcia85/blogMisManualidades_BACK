package com.proyecto.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.proyecto.model.ComentarioVO;
import com.proyecto.request.EmailRequest;
import com.proyecto.request.UpdateComentarioRequest;
import com.proyecto.response.MessageResponse;
import com.proyecto.service.EmailService;

@Controller
public class EmailWSController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/wsEnviarEmail")
	public ResponseEntity<?> enviarEmail(
			 @RequestBody EmailRequest emailRequest) {
		try {
			String mensaje= emailRequest.getTexto() +"\n\n Datos de contacto: "+"\n Nombre: "+ emailRequest.getNombre() +"\n Email: " + emailRequest.getEmail();
			emailService.enviarEmail(emailRequest.getEmail(), "paulagarciasuarezvilloria@gmail.com", emailRequest.getAsunto(), mensaje);
		} catch (Exception e) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse(
							"Se ha producido un error al enviar el email"));
		}

		return ResponseEntity.ok(new MessageResponse("El email ha sido enviado, nos pondremos en contacto contigo en el menor tiempo posible. Gracias"));
	}

}
