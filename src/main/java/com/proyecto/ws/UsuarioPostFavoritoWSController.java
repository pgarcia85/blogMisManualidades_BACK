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
import com.proyecto.model.PostVO;
import com.proyecto.model.UsuarioPostFavoritoDTO;
import com.proyecto.model.UsuarioPostFavoritoVO;
import com.proyecto.model.UsuarioVO;
import com.proyecto.response.MessageResponse;
import com.proyecto.service.PostService;
import com.proyecto.service.UsuarioPostFavoritoService;
import com.proyecto.service.UsuarioService;

@RestController
@CrossOrigin("*")
public class UsuarioPostFavoritoWSController {
	
	@Autowired
	private UsuarioPostFavoritoService usuarioPostFavoritoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PostService postService;
	
	
	
	@PostMapping("/wsUsuarioGuardarPostFavorito")
	public ResponseEntity<?> guardarPostFavorito(
			@Valid @RequestBody UsuarioPostFavoritoDTO postFavorio) {
		try {
			UsuarioVO usuarioVO = usuarioService
					.findById(postFavorio.getIdUsuario()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
			
			PostVO postVO = postService
					.findById(postFavorio.getIdPost()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

			UsuarioPostFavoritoVO usuarioPostFavoritoVO = new UsuarioPostFavoritoVO();
			usuarioPostFavoritoVO.setPostFav(postVO);
			usuarioPostFavoritoVO.setUsuarioFav(usuarioVO);

			usuarioPostFavoritoService.save(usuarioPostFavoritoVO);
		} catch (Exception e) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse(
							"Se ha producido un error al guardar el post como favorito"));
		}

		return ResponseEntity.ok(new MessageResponse("El post se ha añadido a la lista de favoritos"));
	}
	
	@GetMapping("/wsPostFavoritos/{idusuario}")
	public List<PostDTO> getListaPostFavoritosUsuario(@PathVariable("idusuario") Long idusuario){
		List<PostDTO> posts = new ArrayList<>();
		for (UsuarioPostFavoritoVO usuarioPostFavoritoVO : usuarioPostFavoritoService.findAllByUsuarioFavIdusuario(idusuario)) {
			posts.add(new PostDTO(usuarioPostFavoritoVO.getPostFav().getIdpost(), usuarioPostFavoritoVO.getPostFav().getTitulo(), usuarioPostFavoritoVO.getPostFav().getResumen(), usuarioPostFavoritoVO.getPostFav().getTexto(), usuarioPostFavoritoVO.getPostFav().getImagen(), usuarioPostFavoritoVO.getPostFav().getFechacreacion()));
		}	
		return  posts;
	}
	
	@DeleteMapping("/wsPostFavoritosEliminar")
	public ResponseEntity<?> deletePostFavorito(@Valid @RequestBody UsuarioPostFavoritoDTO postFavorio){
		try {
			usuarioService
					.findById(postFavorio.getIdUsuario()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
			
			postService
					.findById(postFavorio.getIdPost()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
			
			usuarioPostFavoritoService.deleteByUsuarioFavIdUsuarioPostFavIdpost(postFavorio.getIdUsuario(), postFavorio.getIdPost());
		} catch (Exception e) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse(
							"Se ha producido un error al eliminar el post como favorito"));
		}

		return ResponseEntity.ok(new MessageResponse("El post se ha eliminado de la lista de favoritos"));
	}
	
	/**
	 * Controlador Rest para actualizar un post favorito
	 * 
	 * @param postFavorito, con los datos que se van a modificar
	 * @return mensaje, con el resultado de la operación
	 */
	@PostMapping("/wsPostFavoritoUpdate")
	public ResponseEntity<?> updatePostFavorito(
			@RequestBody UsuarioPostFavoritoDTO postFavorito) {
		try {
			UsuarioPostFavoritoVO usuarioPostFavoritoVO = usuarioPostFavoritoService
					.findById(postFavorito.getIdusuariopost()).orElseThrow(
							() -> new ResponseStatusException(
									HttpStatus.NOT_FOUND));

			usuarioPostFavoritoVO.setPostFav(postService.findById(postFavorito.getIdPost()).get());

			usuarioPostFavoritoService.save(usuarioPostFavoritoVO);
		} catch (Exception e) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse(
							"Se ha producido un error al modificar el post favorito"));
		}

		return ResponseEntity.ok(new MessageResponse("El post favorito se ha modificado correctamente"));
	}


}
