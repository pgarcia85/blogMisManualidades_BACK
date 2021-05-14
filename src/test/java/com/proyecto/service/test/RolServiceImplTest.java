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
import org.springframework.mail.javamail.JavaMailSender;

import com.proyecto.model.ComentarioVO;
import com.proyecto.model.PostVO;
import com.proyecto.model.RolVO;
import com.proyecto.repository.PostRepository;
import com.proyecto.repository.RolRepository;
import com.proyecto.service.EmailServiceImpl;
import com.proyecto.service.PostServiceImpl;
import com.proyecto.service.RolServiceImpl;

@SpringBootTest
public class RolServiceImplTest {
	
	@InjectMocks
	RolServiceImpl rolServiceImpl;
	 
	@Mock
	RolRepository rolRepository;
	
	@Before
	public void inicio() {
	   MockitoAnnotations.initMocks(this);   
	 }
	
	@Test
	void findByDesrolTest() {
		RolVO rol = Mockito.mock(RolVO.class, Mockito.RETURNS_DEEP_STUBS);
		Mockito.when(rol.getDesrol()).thenReturn("Registrado");
		Optional<RolVO> listaRol = Optional.of(rol);
		
		Mockito.when(rolRepository.findByDesrol(Mockito.anyString())).thenReturn(listaRol);
		
		Assertions.assertEquals("Registrado", rolServiceImpl.findByDesrol("Registrado").get().getDesrol());
	}
	
	@Test
	void deleteByIdTest() {
		
		rolServiceImpl.deleteById(1L);
		
	}
	
	@Test
	void findAllTest() {
		List<RolVO> listaRol = new ArrayList<RolVO>();
		listaRol.add(new RolVO());
		listaRol.add(new RolVO());
		Mockito.when(rolRepository.findAll()).thenReturn(listaRol);
		
		List<RolVO> resultado = (List<RolVO>) rolServiceImpl.findAll();
		Assertions.assertEquals(2, resultado.size());
	}
	
	@Test
	void findByIdTest(){
		RolVO rol = Mockito.mock(RolVO.class, Mockito.RETURNS_DEEP_STUBS);
		Mockito.when(rol.getDesrol()).thenReturn("Registrado");
		Optional<RolVO> listaRol = Optional.of(rol);
		
		Mockito.when(rolRepository.findById(Mockito.any())).thenReturn(listaRol);
		Assertions.assertEquals("Registrado", rolServiceImpl.findById(1L).get().getDesrol());
	}
	
	
	@Test
	void saveTest() {
		RolVO rol = Mockito.mock(RolVO.class, Mockito.RETURNS_DEEP_STUBS);
		Mockito.when(rol.getDesrol()).thenReturn("Registrado");
		
		Mockito.when(rolRepository.save(Mockito.any())).thenReturn(rol);
		
		Assertions.assertEquals("Registrado", rolServiceImpl.save(new RolVO()).getDesrol());
	}

	


}
