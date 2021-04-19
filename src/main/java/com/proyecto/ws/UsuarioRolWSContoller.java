package com.proyecto.ws;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.model.RolVO;
import com.proyecto.model.UsuarioRolDTO;
import com.proyecto.model.UsuarioRolVO;
import com.proyecto.model.UsuarioVO;
import com.proyecto.response.MessageResponse;
import com.proyecto.service.RolService;
import com.proyecto.service.UsuarioRolService;
import com.proyecto.service.UsuarioService;

@RestController
@CrossOrigin("*")
public class UsuarioRolWSContoller {

	
	@Autowired
	private UsuarioRolService usuarioRolService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RolService rolService;

	/**
	 * Controlador Rest para obtener los roles de un usuario. 
	 * @param idusuario, es el identificador del usuario
	 * @return usuario
	 */
	@GetMapping("/wsRolesUsuario/{idusuario}")
	public List<UsuarioRolDTO> getRolesUsuario(@PathVariable("idusuario") Long idusuario) {
		//se crea la lista
		List<UsuarioRolDTO> rolesUsuario = new ArrayList<>();

		for (UsuarioRolVO usuarioRolVO : usuarioRolService.findByUsuarioIdusuario(idusuario)) {
			rolesUsuario.add(new UsuarioRolDTO(usuarioRolVO.getUsuario().getIdusuario(), usuarioRolVO.getUsuario().getNombre(), usuarioRolVO.getRol().getIdrol(), usuarioRolVO.getRol().getDesrol()));
		}
		return rolesUsuario;
	}
	
	/**
	 * Controlador Rest para eliminar un rol a un usuario. 
	 * @param idusuariorol, es el identificador del usuarioRol
	 * @return mensaje, con el resultado de la operación
	 */
	@PostMapping("/wsEliminarUsuarioRol")
	public ResponseEntity<?> eliminarUsuarioRol(@RequestBody UsuarioRolDTO idusuariorol) {
		try {
	       usuarioService.findById(idusuariorol.getIdusuario()).orElseThrow(() -> new Exception("El usuario no existe"));
		   rolService.findById(idusuariorol.getIdrol()).orElseThrow(() ->new Exception("El Rol no existe"));
		
		   UsuarioRolVO usuarioRolVO= usuarioRolService.findByUsuarioIdusuarioAndRolIdrol(idusuariorol.getIdusuario(), idusuariorol.getIdrol())
				   .orElseThrow(() -> new Exception("No se corresponde el rol y el usuario"));
			
		   usuarioRolService.deleteById(usuarioRolVO.getIdusuariorol());
					
		}catch (Exception e) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse(
							"Se ha producido un error al eliminar la relacion entre usuario y rol: "+e.getMessage()));
		}

		return ResponseEntity.ok(new MessageResponse("La relación entre usuario y rol se ha eliminado correctamente"));
	
	}
	
	/**
	 * Controlador Rest para eliminar un rol a un usuario. 
	 * @param idusuariorol, es el identificador del usuarioRol
	 * @return mensaje, con el resultado de la operación
	 */
	@PostMapping("/wsAsignarUsuarioRol")
	public ResponseEntity<?> guardarUsuarioRol(@RequestBody UsuarioRolDTO idusuariorol) {
		try {
			
		UsuarioVO usuario=	usuarioService.findById(idusuariorol.getIdusuario()).orElseThrow(
				() -> new Exception("El usuario no existe"));
		RolVO rol= rolService.findById(idusuariorol.getIdrol()).orElseThrow(
				() -> new Exception("El rol no existe"));
		
		UsuarioRolVO usuarioRolVO = new UsuarioRolVO(usuario,rol);
		usuarioRolService.save(usuarioRolVO);
					
		} catch (Exception e) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse(
							"Se ha producido un error al guardar la relacion entre usuario y rol"));
		}

		return ResponseEntity.ok(new MessageResponse("La relación entre usuario y rol se ha guardado correctamente"));
	
	}

}
