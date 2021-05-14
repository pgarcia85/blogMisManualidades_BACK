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

import com.proyecto.model.PostVO;
import com.proyecto.model.UsuarioPostFavoritoVO;
import com.proyecto.model.UsuarioRolVO;
import com.proyecto.repository.UsuarioPostRepository;
import com.proyecto.repository.UsuarioRolRepository;
import com.proyecto.service.UsuarioPostFavoritoServiceImpl;
import com.proyecto.service.UsuarioRolServiceImpl;

@SpringBootTest
public class UsuarioRolServiceImplTest {
	
	@InjectMocks
	UsuarioRolServiceImpl usuarioRolServiceImpl;
	 
	@Mock
	UsuarioRolRepository usuarioRolRepository;
	
	@Before
	public void inicio() {
	   MockitoAnnotations.initMocks(this);   
	 }
	
	@Test
	void saveTest() {
		UsuarioRolVO usuarioRol = Mockito.mock(UsuarioRolVO.class, Mockito.RETURNS_DEEP_STUBS);
		Mockito.when(usuarioRol.getUsuario().getNombre()).thenReturn("Juan");
		
		Mockito.when(usuarioRolRepository.save(Mockito.any())).thenReturn(usuarioRol);
		
		Assertions.assertEquals("Juan", usuarioRolServiceImpl.save(new UsuarioRolVO()).getUsuario().getNombre());
	}
	
	@Test
	void findAllTest() {
		UsuarioRolVO usuarioRol = Mockito.mock(UsuarioRolVO.class, Mockito.RETURNS_DEEP_STUBS);
		Mockito.when(usuarioRol.getUsuario().getNombre()).thenReturn("Juan");
		List<UsuarioRolVO> listaUsuarioRol = new ArrayList<>();
		listaUsuarioRol.add(usuarioRol);
		
		Mockito.when(usuarioRolRepository.findAll()).thenReturn(listaUsuarioRol);
		
		List<UsuarioRolVO> resultado = (List<UsuarioRolVO>) usuarioRolServiceImpl.findAll();
		
		Assertions.assertEquals("Juan", resultado.get(0).getUsuario().getNombre());
	}
	
	@Test
	void deleteByIdTest() {		
		usuarioRolServiceImpl.deleteById(1);		
	}
	
	@Test
	void findByUsuarioIdusuarioTest(){
		UsuarioRolVO usuarioRol = Mockito.mock(UsuarioRolVO.class, Mockito.RETURNS_DEEP_STUBS);
		Mockito.when(usuarioRol.getUsuario().getNombre()).thenReturn("Juan");
		List<UsuarioRolVO> listaUsuarioRol = new ArrayList<>();
		listaUsuarioRol.add(usuarioRol);
		
		Mockito.when(usuarioRolRepository.findByUsuarioIdusuario(Mockito.anyLong())).thenReturn(listaUsuarioRol);
		List<UsuarioRolVO> resultado =  (List<UsuarioRolVO>) usuarioRolServiceImpl.findByUsuarioIdusuario(1L);
		Assertions.assertEquals("Juan", resultado.get(0).getUsuario().getNombre());
	}
	
	
	
	@Test
	void findByUsuarioIdusuarioAndRolIdrolTest(){
		UsuarioRolVO usuarioRol = Mockito.mock(UsuarioRolVO.class, Mockito.RETURNS_DEEP_STUBS);
		Mockito.when(usuarioRol.getUsuario().getNombre()).thenReturn("Juan");
		Optional<UsuarioRolVO> listaUsuarioRol = Optional.of(usuarioRol);
		
		Mockito.when(usuarioRolRepository.findByUsuarioIdusuarioAndRolIdrol(Mockito.anyLong(), Mockito.anyLong())).thenReturn(listaUsuarioRol);
		
		Assertions.assertEquals("Juan", usuarioRolServiceImpl.findByUsuarioIdusuarioAndRolIdrol(1L, 1L).get().getUsuario().getNombre());
	}
	

	
	


	


}
