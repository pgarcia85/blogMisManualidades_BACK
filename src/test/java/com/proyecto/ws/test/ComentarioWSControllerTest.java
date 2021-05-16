package com.proyecto.ws.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyecto.model.ComentarioDTO;
import com.proyecto.model.ComentarioVO;
import com.proyecto.model.PostVO;
import com.proyecto.model.UsuarioVO;
import com.proyecto.request.UpdateComentarioRequest;
import com.proyecto.service.ComentarioService;
import com.proyecto.service.PostService;
import com.proyecto.service.UsuarioService;
import com.proyecto.ws.ComentarioWSController;

@SpringBootTest
public class ComentarioWSControllerTest {
	
	@InjectMocks
	ComentarioWSController comentarioWSController;
	
	@Mock
	ComentarioService comentarioService;
	
	@Mock
	PostService postService;
	
	@Mock
	UsuarioService usuarioService;
	
	@Before
	public void inicio() {
	   MockitoAnnotations.initMocks(this);   
	 }
	
	@Test
	void getComentariosPostTest() {
		List<ComentarioVO> listaComentarios = new ArrayList<>();
		listaComentarios.add(Mockito.mock(ComentarioVO.class, Mockito.RETURNS_DEEP_STUBS));
		Mockito.when(comentarioService.findByIdpost(Mockito.anyInt())).thenReturn(listaComentarios);
		
		Assertions.assertEquals(1, comentarioWSController.getComentariosPost(1).size());
	}
	
	@Test
	void getComentarioTest() {
		ComentarioVO comentario = Mockito.mock(ComentarioVO.class, Mockito.RETURNS_DEEP_STUBS);
		Mockito.when(comentario.getTextocomentario()).thenReturn("Texto test");
		Optional<ComentarioVO> listaComentario = Optional.of(comentario);
		
		Mockito.when(comentarioService.findById(Mockito.anyInt())).thenReturn(listaComentario);
		
		Assertions.assertEquals("Texto test", comentarioWSController.getComentario(1).getTexto());
		
	}
	
	@Test
	void insertaComentarioTest() {
		ComentarioDTO comentario = Mockito.mock(ComentarioDTO.class, Mockito.RETURNS_DEEP_STUBS);
		Mockito.when(comentario.getTexto()).thenReturn("Texto test");
		
		Optional<PostVO> listapost = Optional.of(Mockito.mock(PostVO.class, Mockito.RETURNS_DEEP_STUBS));
		Mockito.when(postService.findById(Mockito.anyInt())).thenReturn(listapost);
		Optional<UsuarioVO> listaUsuario = Optional.of(Mockito.mock(UsuarioVO.class, Mockito.RETURNS_DEEP_STUBS));
		Mockito.when(usuarioService.findById(Mockito.anyLong())).thenReturn(listaUsuario);
		
		Optional<ComentarioVO> listaComentario = Optional.of(Mockito.mock(ComentarioVO.class, Mockito.RETURNS_DEEP_STUBS));					
		Mockito.when(comentarioService.findById(Mockito.anyInt())).thenReturn(listaComentario);
		
		Assertions.assertEquals("Texto test", comentarioWSController.insertaComentario(comentario).getTexto());
	}
	
	@Test
	void eliminaComentarioTest(){
				
		Assertions.assertEquals(200, comentarioWSController.eliminaComentario(1).getStatusCodeValue());
	}
	
	@Test
	void eliminaComentarioErrorTest(){
		Mockito.doThrow(NullPointerException.class).when(comentarioService).deleteById(Mockito.anyInt());
		
		Assertions.assertEquals(400, comentarioWSController.eliminaComentario(1).getStatusCodeValue());
	}
	
	@Test
	void updateComentarioTest(){
		//Mock de la request
		UpdateComentarioRequest updateComentario = Mockito.mock(UpdateComentarioRequest.class, Mockito.RETURNS_DEEP_STUBS);
		
		Mockito.when(comentarioService.findById(Mockito.anyInt())).thenReturn( Optional.of(Mockito.mock(ComentarioVO.class, Mockito.RETURNS_DEEP_STUBS)));
		
		Assertions.assertEquals(200, comentarioWSController.updateComentario(updateComentario).getStatusCodeValue());
	}
	
	@Test
	void updateComentarioErrorTest(){
		//Mock de la request
		UpdateComentarioRequest updateComentario = Mockito.mock(UpdateComentarioRequest.class, Mockito.RETURNS_DEEP_STUBS);
		// se lanza una excepcion al llamar al servicio
		Mockito.doThrow(NullPointerException.class).when(comentarioService).findById(Mockito.anyInt());
		
		Assertions.assertEquals(400, comentarioWSController.updateComentario(updateComentario).getStatusCodeValue());
	}
}
