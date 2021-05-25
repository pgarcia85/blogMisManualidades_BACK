package com.proyecto.ws;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.proyecto.model.RolVO;
import com.proyecto.model.UsuarioRolVO;
import com.proyecto.model.UsuarioVO;
import com.proyecto.request.LoginRequest;
import com.proyecto.request.SigupRequest;
import com.proyecto.response.JwtResponse;
import com.proyecto.response.MessageResponse;
import com.proyecto.service.RolService;
import com.proyecto.service.UserDetailsImpl;
import com.proyecto.service.UsuarioRolService;
import com.proyecto.service.UsuarioService;
import com.proyecto.utils.JwtUtils;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthWSController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRolService usuarioRolService;

	@Autowired
	private RolService rolService;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private JwtUtils jwtUtils;

	/**
	 * Controlador Rest para iniciar sesion
	 * 
	 * @param loginRequest
	 * @return
	 */
	@PostMapping("/singin")
	public ResponseEntity<?> authenticateUser(
			@Valid @RequestBody LoginRequest loginRequest) {

		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(
							loginRequest.getEmail(), loginRequest
									.getContrasenia()));

			SecurityContextHolder.getContext()
					.setAuthentication(authentication);
			String jwt = jwtUtils.generateToken(authentication);

			UserDetailsImpl userDetails = (UserDetailsImpl) authentication
					.getPrincipal();
			List<String> roles = userDetails.getAuthorities().stream()
					.map(item -> item.getAuthority())
					.collect(Collectors.toList());

			return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(),
					userDetails.getNombre(), userDetails.getEmail(),
					userDetails.getContrasena(), roles));

		} catch (BadCredentialsException e) {
			return ResponseEntity.badRequest().body(
					new MessageResponse(
							"Las credenciales de acceso son incorrectas"));
		}

	}

	/**
	 * Controlador Rest para registrar usuario
	 * 
	 * @param sigupRequest
	 * @return
	 */
	@PostMapping("/singup")
	public ResponseEntity<?> registerUser(
			@Valid @RequestBody SigupRequest sigupRequest) {
		if (usuarioService.existsByEmail(sigupRequest.getEmail())) {
			return ResponseEntity.badRequest().body(
					new MessageResponse("Ya existe un usuario con ese email"));
		}

		if (usuarioService.existsByContrasena(sigupRequest.getContrasena())) {
			return ResponseEntity.badRequest().body(
					new MessageResponse(
							"Ya existe un usuario con esa contraseña"));
		}

		// crear una nueva cuenta de usuario
		UsuarioVO usuario = new UsuarioVO(sigupRequest.getNombre(),
				sigupRequest.getApellidos(), sigupRequest.getEmail(),
				sigupRequest.getTelefono(), sigupRequest.getDireccion(),
				encoder.encode(sigupRequest.getContrasena()));
		
		usuarioService.save(usuario);
		UsuarioRolVO usuarioRol = new UsuarioRolVO();
		RolVO rol = rolService.findByDesrol("ROLE_REGISTRADO").orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		usuarioRol.setRol(rol);
		usuarioRol.setUsuario(usuario);
		usuarioRolService.save(usuarioRol);

		return ResponseEntity.ok(new MessageResponse(
				"El usuario se ha registrado correctamente"));

	}

}
