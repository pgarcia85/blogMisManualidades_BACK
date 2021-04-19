package com.proyecto.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.proyecto.model.RolDTO;
import com.proyecto.model.RolVO;
import com.proyecto.response.MessageResponse;
import com.proyecto.service.RolService;

@RestController
@CrossOrigin("*")
public class RolWSController {
	
	@Autowired
	private RolService rolService;
	
	/**
	 * Controlador Rest para obtener todos los Roles. 
	 * 
	 * @return lista con los roles
	 */
	@GetMapping("/wslistaRol")
	public List<RolDTO> getListaRoles() {
		//se crea la lista
		List<RolDTO> roles = new ArrayList<>();
		//se consulta a bd la lista de roles y se añaden a la lista 
		for (RolVO rolVO : rolService.findAll()) {
			roles.add(new RolDTO(rolVO.getIdrol(), rolVO.getDesrol()));
		}
		return roles;
	}

	/**
	 * Controlador Rest para obtener un rol en concreto. 
	 * 
	 * @param idrol, es el identificador del rol
	 * @return rol
	 */
	@GetMapping("/wsRolId/{idrol}")
	public RolDTO getRol(@PathVariable("idrol") Long idrol) {
		RolVO rolVO = rolService.findById(idrol).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		RolDTO rol = new RolDTO(rolVO.getIdrol(), rolVO.getDesrol());

		return rol;
	}

	/**
	 * Controlador Rest para guardar un nuevo rol
	 * 
	 * @param rol, rol que se va a guardar
	 * @return rol guardado
	 */
	@PostMapping("/wsInsertaRol")
	public ResponseEntity<?> insertaRol(@RequestBody RolDTO rol) {
		RolVO rolGuardado =null;
		try {
			RolVO rolNuevo = new RolVO(rol.getDesRol());
			 rolGuardado = rolService.save(rolNuevo);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(
					new MessageResponse(
							"Se ha producido un error al guardar el rol"));
		}

		return ResponseEntity.ok(new RolDTO(rolGuardado.getIdrol(), rolGuardado.getDesrol()));
	}
	/**
	 * Controlador Rest para eliminar un rol. 
	 * 
	 * @param idrol, es el identificador del rol
	 * @return mensaje, con el resultado de la operación
	 */
	@PostMapping("/wsEliminarRol/{idrol}")
	public ResponseEntity<?> eliminaRol(@PathVariable("idrol") Long idrol) {
		try {

			rolService.deleteById(idrol);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(
					new MessageResponse(
							"Se ha producido un error al eliminar el rol"));
		}

		return ResponseEntity.ok(new MessageResponse(
				"El rol ha sido eliminado correctamente"));
	}
	
	
	/**
	 * Controlador Rest para actualizar un rol
	 * (se puede modificar la descripcion)
	 * 
	 * @param updateRequest, con los datos que se van a modificar
	 * @return mensaje, con el resultado de la operación
	 */
	@PostMapping("/wsRolUpdate")
	public ResponseEntity<?> updateRol(
			 @RequestBody RolDTO rol) {
		try {
			RolVO rolVO = rolService
					.findById(rol.getIdRol()).orElseThrow(
							() -> new ResponseStatusException(
									HttpStatus.NOT_FOUND));

			rolVO.setDesrol(rol.getDesRol());
			
			rolService.save(rolVO);
			
		} catch (Exception e) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse(
							"Se ha producido un error al modificar el post"));
		}

		return ResponseEntity.ok(new MessageResponse("El post se ha modificado correctamente"));
	}

}
