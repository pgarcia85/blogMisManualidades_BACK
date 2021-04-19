package com.proyecto.ws;

import java.time.LocalDate;
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

import com.proyecto.model.ComentarioDTO;
import com.proyecto.model.ComentarioVO;
import com.proyecto.request.UpdateComentarioRequest;
import com.proyecto.response.MessageResponse;
import com.proyecto.service.ComentarioService;
import com.proyecto.service.PostService;
import com.proyecto.service.UsuarioService;


@RestController
@CrossOrigin("*")
public class ComentarioWSController {

	
	@Autowired
	private ComentarioService comentarioService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/wsComentariosPost/{idpost}")
	public List<ComentarioDTO> getComentariosPost(@PathVariable("idpost") Integer idpost){
		List<ComentarioDTO> listaComentarios = new ArrayList<>();
		for(ComentarioVO comentario: comentarioService.findByIdpost(idpost)){
			ComentarioDTO comen = new ComentarioDTO(comentario.getIdcomentario(),comentario.getTextocomentario(),comentario.getFechacreacion(), comentario.getUsuarioComen().getNombre());
			listaComentarios.add(comen);
		}
			
		return  listaComentarios;
	}
	
	@GetMapping("/wsComentario/{idcomentario}")
	public ComentarioDTO getComentario(@PathVariable("idcomentario") Integer idcomentario){
		
		ComentarioVO comentario= comentarioService.findById(idcomentario).get();
		ComentarioDTO comen = new ComentarioDTO(comentario.getIdcomentario(),comentario.getTextocomentario(),comentario.getFechacreacion(), comentario.getUsuarioComen().getNombre());				
			
		return  comen;
	}
	
	@PostMapping("/wsInsertaComentario")
	public ComentarioDTO insertaComentario(@RequestBody ComentarioDTO comentario){
		ComentarioVO comen = new ComentarioVO(comentario.getTexto(),  LocalDate.now(),  postService.findById(comentario.getIdPost()).get(), usuarioService.findById(comentario.getIdUsuario()).get());
		comentarioService.save(comen);
		
		return new ComentarioDTO(comen.getIdcomentario(), comen.getTextocomentario(), comen.getFechacreacion(), comen.getPost().getIdpost(),comen.getUsuarioComen().getNombre(),comen.getUsuarioComen().getIdusuario());
	}
	
	@PostMapping("/wsEliminarComentario/{idcomentario}")
	public ResponseEntity<?> eliminaComentario(@PathVariable("idcomentario") Integer idcomentario) {
		try {

			comentarioService.deleteById(idcomentario);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(
					new MessageResponse(
							"Se ha producido un error al eliminar el comentario"));
		}

		return ResponseEntity.ok(new MessageResponse(
				"El comentario ha sido eliminado correctamente"));
	}
	
	/**
	 * Controlador Rest para actualizar un comentario
	 * Actualiza el texto del comentario
	 * 
	 * @param updateRequest, con los datos que se van a modificar
	 * @return mensaje, con el resultado de la operación
	 */
	@PostMapping("/wsComentarioUpdate")
	public ResponseEntity<?> updateComentario(
			 @RequestBody UpdateComentarioRequest updateRequest) {
		try {
			ComentarioVO comentarioVO = comentarioService
					.findById(updateRequest.getIdComentario()).orElseThrow(
							() -> new ResponseStatusException(
									HttpStatus.NOT_FOUND));

			comentarioVO.setTextocomentario(updateRequest.getTexto());

			comentarioService.save(comentarioVO);
		} catch (Exception e) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse(
							"Se ha producido un error al modificar el post"));
		}

		return ResponseEntity.ok(new MessageResponse("El post se ha modificado correctamente"));
	}
}
