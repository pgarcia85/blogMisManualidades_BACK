package com.proyecto.ws;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
import com.proyecto.model.PostVO;
import com.proyecto.request.UpdatePostRequest;
import com.proyecto.response.MessageResponse;
import com.proyecto.service.PostService;

@RestController
@CrossOrigin("*")
public class PostWSController {

	@Autowired
	private PostService postService;

	@GetMapping("/wslistaPost")
	public List<PostDTO> getListaPost() {
		List<PostDTO> posts = new ArrayList<>();
		for (PostVO postlVO : postService.findAll()) {
			posts.add(new PostDTO(postlVO.getIdpost(), postlVO.getTitulo(),
					postlVO.getResumen(), postlVO.getTexto(), postlVO
							.getImagen(), postlVO.getFechacreacion()));
		}
		return posts;
	}

	/**
	 * Controlador Rest para obtener un post por su identificador
	 * 
	 * @param idpost
	 * @return
	 */
	@GetMapping("/wsPostId/{idpost}")
	public PostDTO getPost(@PathVariable("idpost") Integer idpost) {
		PostVO postlVO = postService.findById(idpost).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		PostDTO post = new PostDTO(postlVO.getIdpost(), postlVO.getTitulo(),
				postlVO.getResumen(), postlVO.getTexto(), postlVO.getImagen(),
				postlVO.getFechacreacion());

		return post;
	}

	/**
	 * Controlador Rest para insertar un Post
	 * 
	 * @param post
	 * @return
	 */
	@PostMapping("/wsInsertaPost")
	public ResponseEntity<?> insertaPost(@RequestBody PostDTO post) {
		try {
			PostVO postNuevo = new PostVO(post.getTitulo(), post.getResumen(),
					post.getTexto(), "noImagen.jpg", LocalDate.now());
			postService.save(postNuevo);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(
					new MessageResponse(
							"Se ha producido un error al guardar el post"));
		}

		return ResponseEntity.ok(new MessageResponse(
				"El post se ha sido guardado correctamente"));
	}

	/**
	 * Controlador Rest para eliminar un post
	 * 
	 * @param idpost
	 * @return
	 */
	@DeleteMapping("/wsEliminarPost/{idpost}")
	public ResponseEntity<?> eliminaPost(@PathVariable("idpost") Integer idpost) {
		try {

			postService.deleteById(idpost);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(
					new MessageResponse(
							"Se ha producido un error al eliminar el post"));
		}

		return ResponseEntity.ok(new MessageResponse(
				"El post ha sido eliminado correctamente"));
	}
	
	/**
	 * Controlador Rest para actualizar un post
	 * (se pueden modificar, titulo, texto, resumen e imagen)
	 * 
	 * @param updateRequest, con los datos que se van a modificar
	 * @return mensaje, con el resultado de la operación
	 */
	@PostMapping("/wsPostUpdate")
	public ResponseEntity<?> updatePost(
			 @RequestBody UpdatePostRequest updateRequest) {
		try {
			PostVO postVO = postService
					.findById(updateRequest.getIdpost()).orElseThrow(
							() -> new ResponseStatusException(
									HttpStatus.NOT_FOUND));

			postVO.setTitulo(updateRequest.getTitulo());
			postVO.setResumen(updateRequest.getResumen());
			postVO.setTexto(updateRequest.getTexto());

			postService.save(postVO);
		} catch (Exception e) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse(
							"Se ha producido un error al modificar el post"));
		}

		return ResponseEntity.ok(new MessageResponse("El post se ha modificado correctamente"));
	}

}
