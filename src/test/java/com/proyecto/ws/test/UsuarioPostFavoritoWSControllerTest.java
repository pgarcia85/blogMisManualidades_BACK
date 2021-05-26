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

import com.proyecto.model.PostVO;
import com.proyecto.model.UsuarioPostFavoritoDTO;
import com.proyecto.model.UsuarioPostFavoritoVO;
import com.proyecto.model.UsuarioVO;
import com.proyecto.service.PostService;
import com.proyecto.service.UsuarioPostFavoritoService;
import com.proyecto.service.UsuarioService;
import com.proyecto.ws.UsuarioPostFavoritoWSController;

@SpringBootTest
public class UsuarioPostFavoritoWSControllerTest {
	
	@InjectMocks
	UsuarioPostFavoritoWSController usuarioPostFavoritoWSController;	
	
	@Mock
	private UsuarioPostFavoritoService usuarioPostFavoritoService;
	
	@Mock
	private UsuarioService usuarioService;
	
	@Mock
	private PostService postService;
	
	@Before
	public void inicio() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void guardarPostFavoritoTest(){
		UsuarioPostFavoritoDTO usuarioPostFavoritoDTO = Mockito.mock(UsuarioPostFavoritoDTO.class, Mockito.RETURNS_DEEP_STUBS);
		
		UsuarioVO usuario = Mockito.mock(UsuarioVO.class, Mockito.RETURNS_DEEP_STUBS);
		Optional<UsuarioVO> listaUsu = Optional.of(usuario);
		Mockito.when(usuarioService.findById(Mockito.anyLong())).thenReturn(listaUsu);
		
		PostVO post = Mockito.mock(PostVO.class, Mockito.RETURNS_DEEP_STUBS);
		Optional<PostVO> listaPost = Optional.of(post);
		Mockito.when(postService.findById(Mockito.anyInt())).thenReturn(listaPost);
		
		Assertions.assertEquals(200, usuarioPostFavoritoWSController.guardarPostFavorito(usuarioPostFavoritoDTO).getStatusCodeValue());
	}
	
	
	@Test
	public void getListaPostFavoritosUsuarioTest(){
		List<UsuarioPostFavoritoVO> postsFav = new ArrayList<>();
		postsFav.add(Mockito.mock(UsuarioPostFavoritoVO.class, Mockito.RETURNS_DEEP_STUBS));
		
		Mockito.when(usuarioPostFavoritoService.findAllByUsuarioFavIdusuario(Mockito.anyLong())).thenReturn(postsFav);
		
		Assertions.assertEquals(1, usuarioPostFavoritoWSController.getListaPostFavoritosUsuario(1L).size());
	}
	
	@Test
	public void deletePostFavoritoTest(){
		
		UsuarioVO usuario = Mockito.mock(UsuarioVO.class, Mockito.RETURNS_DEEP_STUBS);
		Optional<UsuarioVO> listaUsu = Optional.of(usuario);
		Mockito.when(usuarioService.findById(Mockito.anyLong())).thenReturn(listaUsu);
		
		PostVO post = Mockito.mock(PostVO.class, Mockito.RETURNS_DEEP_STUBS);
		Optional<PostVO> listaPost = Optional.of(post);
		Mockito.when(postService.findById(Mockito.anyInt())).thenReturn(listaPost);
		
		
		Assertions.assertEquals(200, usuarioPostFavoritoWSController.deletePostFavorito(1L, 20).getStatusCodeValue());
	}
	
	@Test
	public void updatePostFavoritoTest(){
		UsuarioPostFavoritoDTO usuarioPostFavoritoDTO = Mockito.mock(UsuarioPostFavoritoDTO.class, Mockito.RETURNS_DEEP_STUBS);
		
		UsuarioPostFavoritoVO usuarioPostFavoritoVO = Mockito.mock(UsuarioPostFavoritoVO.class, Mockito.RETURNS_DEEP_STUBS);
		Optional<UsuarioPostFavoritoVO> listaPostFav = Optional.of(usuarioPostFavoritoVO);
		Mockito.when(usuarioPostFavoritoService.findById(Mockito.anyInt())).thenReturn(listaPostFav);
		
		PostVO post = Mockito.mock(PostVO.class, Mockito.RETURNS_DEEP_STUBS);
		Optional<PostVO> listaPost = Optional.of(post);
		Mockito.when(postService.findById(Mockito.anyInt())).thenReturn(listaPost);
		
		Assertions.assertEquals(200, usuarioPostFavoritoWSController.updatePostFavorito(usuarioPostFavoritoDTO).getStatusCodeValue());
	}
	
	@Test
	public void updatePostErrorTest(){
		UsuarioPostFavoritoDTO usuarioPostFavoritoDTO = Mockito.mock(UsuarioPostFavoritoDTO.class, Mockito.RETURNS_DEEP_STUBS);
		
		UsuarioPostFavoritoVO usuarioPostFavoritoVO = Mockito.mock(UsuarioPostFavoritoVO.class, Mockito.RETURNS_DEEP_STUBS);
		Optional<UsuarioPostFavoritoVO> listaPostFav = Optional.of(usuarioPostFavoritoVO);
		Mockito.when(usuarioPostFavoritoService.findById(Mockito.anyInt())).thenReturn(listaPostFav);
		
		Mockito.doThrow(NullPointerException.class).when(postService).findById(Mockito.anyInt());
		
		Assertions.assertEquals(400, usuarioPostFavoritoWSController.updatePostFavorito(usuarioPostFavoritoDTO).getStatusCodeValue());
	}

}
