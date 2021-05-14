package com.proyecto.service.test;

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

import com.proyecto.model.UsuarioPostFavoritoVO;
import com.proyecto.repository.UsuarioPostRepository;
import com.proyecto.service.UsuarioPostFavoritoServiceImpl;

@SpringBootTest
public class UsuarioPostFavoritoServiceImplTest {
	
	@InjectMocks
	UsuarioPostFavoritoServiceImpl usuarioPostFavoritoServiceImpl;
	 
	@Mock
	UsuarioPostRepository usuarioPostRepository;
	
	@Before
	public void inicio() {
	   MockitoAnnotations.initMocks(this);   
	 }
	
	@Test
	void saveTest() {
		UsuarioPostFavoritoVO usuarioPostFavorito = Mockito.mock(UsuarioPostFavoritoVO.class, Mockito.RETURNS_DEEP_STUBS);
		Mockito.when(usuarioPostFavorito.getPostFav().getIdpost()).thenReturn(1);
		
		Mockito.when(usuarioPostRepository.save(Mockito.any())).thenReturn(usuarioPostFavorito);
		
		Assertions.assertEquals(1, usuarioPostFavoritoServiceImpl.save(new UsuarioPostFavoritoVO()).getPostFav().getIdpost());
	}
	
	@Test
	void findAllByUsuarioFavIdusuarioTest() {
		UsuarioPostFavoritoVO usuarioPostFavorito = Mockito.mock(UsuarioPostFavoritoVO.class, Mockito.RETURNS_DEEP_STUBS);
		Mockito.when(usuarioPostFavorito.getPostFav().getIdpost()).thenReturn(1);
		List<UsuarioPostFavoritoVO> listaUsuarioPostFav = new ArrayList<>();
		listaUsuarioPostFav.add(usuarioPostFavorito);
		
		Mockito.when(usuarioPostRepository.findAllByUsuarioFavIdusuario(Mockito.anyLong())).thenReturn(listaUsuarioPostFav);
		
		Assertions.assertEquals(1, usuarioPostFavoritoServiceImpl.findAllByUsuarioFavIdusuario(1L).get(0).getPostFav().getIdpost());
	}
	
	@Test
	void deleteByIdTest() {		
		usuarioPostFavoritoServiceImpl.deleteById(1);		
	}
	
	@Test
	void findByIdTest(){
		UsuarioPostFavoritoVO usuarioPostFavorito = Mockito.mock(UsuarioPostFavoritoVO.class, Mockito.RETURNS_DEEP_STUBS);
		Mockito.when(usuarioPostFavorito.getPostFav().getTexto()).thenReturn("Texto");
		Optional<UsuarioPostFavoritoVO> listaUsuPostFav = Optional.of(usuarioPostFavorito);
		
		Mockito.when(usuarioPostRepository.findById(Mockito.any())).thenReturn(listaUsuPostFav);
		
		Assertions.assertEquals("Texto", usuarioPostFavoritoServiceImpl.findById(1).get().getPostFav().getTexto());
	}
	
	
	
	@Test
	void deleteByUsuarioFavIdUsuarioPostFavIdpostTest() {
		
		Mockito.when(usuarioPostRepository.deleteByUsuarioFavIdusuarioAndPostFavIdpost(Mockito.anyLong(), Mockito.anyInt())).thenReturn(1L);	
		
		Assertions.assertEquals(1, usuarioPostFavoritoServiceImpl.deleteByUsuarioFavIdUsuarioPostFavIdpost(1L, 1));
	}
	

	
	


	


}
