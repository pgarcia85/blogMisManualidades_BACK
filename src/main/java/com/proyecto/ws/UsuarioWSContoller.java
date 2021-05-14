package com.proyecto.ws;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.proyecto.model.PostDTO;
import com.proyecto.model.UsuarioDTO;
import com.proyecto.model.UsuarioVO;
import com.proyecto.request.UpdateUsuarioRequest;
import com.proyecto.response.MessageResponse;
import com.proyecto.service.UsuarioService;

@RestController
@CrossOrigin("*")
public class UsuarioWSContoller {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/wsUsuarioId/{idusuario}")
	public UsuarioDTO getDatosUsuario(@PathVariable("idusuario") Long idusuario) {

		UsuarioVO usuarioVO = usuarioService.findById(idusuario).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		UsuarioDTO usuario = new UsuarioDTO(usuarioVO.getIdusuario(),usuarioVO.getNombre(),
				usuarioVO.getApellidos(), usuarioVO.getEmail(),
				usuarioVO.getTelefono(), usuarioVO.getDireccion(),
				usuarioVO.getContrasena());

		return usuario;
	}

	@PostMapping("/wsUsuarioUpdate")
	public ResponseEntity<?> updateUsuario(
			@Valid @RequestBody UpdateUsuarioRequest updateRequest) {
		try {
			UsuarioVO usuarioVO = usuarioService
					.findById(updateRequest.getId()).orElseThrow(
							() -> new ResponseStatusException(
									HttpStatus.NOT_FOUND));

			usuarioVO.setNombre(updateRequest.getNombre());
			usuarioVO.setApellidos(updateRequest.getApellidos());
			usuarioVO.setTelefono(updateRequest.getTelefono());
			usuarioVO.setDireccion(updateRequest.getDireccion());

			usuarioService.save(usuarioVO);
		} catch (Exception e) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse(
							"Se ha producido un error al modificar el usuario"));
		}

		return ResponseEntity.ok(new MessageResponse("El usuario se ha modificado correctamente"));
	}
	
	@DeleteMapping("/wsEliminarUsuario/{idusuario}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable("idusuario") Long idusuario) {
		try {
			 usuarioService.deleteById(idusuario);
					
		} catch (Exception e) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse(
							"Se ha producido un error al eliminar el usuario"));
		}

		return ResponseEntity.ok(new MessageResponse("El usuario se ha eliminado correctamente"));
	
	}
	
	@GetMapping("/wsUsuarios")
	public List<UsuarioDTO> getUsuarios() {

		List<UsuarioDTO> usuarios = new ArrayList<>();
		for (UsuarioVO usu : usuarioService.findByRolesRolIdrol(2L)) {
			usuarios.add(new UsuarioDTO(usu.getIdusuario(), usu.getNombre(),
					usu.getApellidos(), usu.getEmail(), usu.getTelefono(), usu
							.getDireccion(), usu.getContrasena()));
		}

		return usuarios;

	}

}
