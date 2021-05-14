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

import com.proyecto.model.UsuarioRolVO;
import com.proyecto.model.UsuarioVO;
import com.proyecto.repository.UsuarioRepository;
import com.proyecto.service.UsuarioServiceImpl;

@SpringBootTest
public class UsuarioServiceImplTest {
	
	@InjectMocks
	UsuarioServiceImpl usuarioServiceImpl;
	 
	@Mock
	UsuarioRepository usuarioRepository;
	
	@Before
	public void inicio() {
	   MockitoAnnotations.initMocks(this);   
	 }
	
	@Test
	void existsByEmailTest(){
		
		Mockito. when(usuarioRepository.existsByEmail(Mockito.anyString())).thenReturn(true);
		Assertions.assertTrue(usuarioServiceImpl.existsByEmail("email"));
	}
	
	@Test
	void existsByContrasenaTest(){
		
		Mockito. when(usuarioRepository.existsByContrasena(Mockito.anyString())).thenReturn(false);
		Assertions.assertFalse(usuarioServiceImpl.existsByEmail("contrasenia"));
	}
	
	@Test
	void findByIdTest() {
		UsuarioVO usuario = Mockito.mock(UsuarioVO.class, Mockito.RETURNS_DEEP_STUBS);
		Mockito.when(usuario.getNombre()).thenReturn("Juan");
		Optional<UsuarioVO> listaUsuario = Optional.of(usuario);
		
		Mockito.when(usuarioRepository.findById(Mockito.anyLong())).thenReturn(listaUsuario);
		
		Assertions.assertEquals("Juan", usuarioServiceImpl.findById(1L).get().getNombre());
	}
	
	@Test
	void saveTest() {
		UsuarioVO usuario = Mockito.mock(UsuarioVO.class, Mockito.RETURNS_DEEP_STUBS);
		Mockito.when(usuario.getNombre()).thenReturn("Juan");
		
		Mockito.when(usuarioRepository.save(Mockito.any())).thenReturn(usuario);
		
		Assertions.assertEquals("Juan", usuarioServiceImpl.save(new UsuarioVO()).getNombre());
	}
	
	@Test
	void deleteByIdTest() {		
		usuarioServiceImpl.deleteById(1L);		
	}
	
	
	@Test
	void findAllTest() {
		UsuarioVO usuario = Mockito.mock(UsuarioVO.class, Mockito.RETURNS_DEEP_STUBS);
		Mockito.when(usuario.getNombre()).thenReturn("Juan");
		List<UsuarioVO> listaUsuario = new ArrayList<>();
		listaUsuario.add(usuario);
		
		Mockito.when(usuarioRepository.findAll()).thenReturn(listaUsuario);
		
		List<UsuarioVO> resultado = (List<UsuarioVO>) usuarioServiceImpl.findAll();
		
		Assertions.assertEquals("Juan", resultado.get(0).getNombre());
	}
	
	
	@Test
	void findByRolesRolIdrolTest(){
		UsuarioVO usuario = Mockito.mock(UsuarioVO.class, Mockito.RETURNS_DEEP_STUBS);
		Mockito.when(usuario.getNombre()).thenReturn("Juan");
		List<UsuarioVO> listaUsuario = new ArrayList<>();
		listaUsuario.add(usuario);
		
		Mockito.when(usuarioRepository.findByRolesRolIdrol(Mockito.anyLong())).thenReturn(listaUsuario);
		List<UsuarioVO> resultado =  (List<UsuarioVO>) usuarioServiceImpl.findByRolesRolIdrol(1L);
		Assertions.assertEquals("Juan", resultado.get(0).getNombre());
	}
	


}
