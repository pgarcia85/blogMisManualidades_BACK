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

import com.proyecto.model.ComentarioVO;
import com.proyecto.repository.ComentarioRepository;
import com.proyecto.service.ComentarioServiceImpl;


@SpringBootTest
public class ComentarioServiceImplTest {
	
	@InjectMocks
	ComentarioServiceImpl comentarioService;
	 
	@Mock
	ComentarioRepository comentarioRepo;
	

	
	@Before
	public void inicio() {
	   MockitoAnnotations.initMocks(this);   
	 }

		
	
	@Test
	void findByIdpostTest() {
		List<ComentarioVO> listaComentarios = new ArrayList<ComentarioVO>();
		listaComentarios.add(new ComentarioVO());
		listaComentarios.add(new ComentarioVO());
		Mockito.when(comentarioRepo.findByPostIdpostOrderByFechacreacionAsc(Mockito.anyInt())).thenReturn(listaComentarios);
		
		Assertions.assertEquals(2, comentarioService.findByIdpost(1).size());
	}
	
	@Test
	void saveComentarioTest() {
		ComentarioVO comenta = Mockito.mock(ComentarioVO.class, Mockito.RETURNS_DEEP_STUBS);
		Mockito.when(comenta.getTextocomentario()).thenReturn("Texto test");
		
		Mockito.when(comentarioRepo.save(Mockito.any())).thenReturn(comenta);
		
		Assertions.assertEquals("Texto test", comentarioService.save(new ComentarioVO()).getTextocomentario());
	}

	@Test
	void deleteComentarioTest() {
		
		comentarioService.deleteById(1);
		
	}

	@Test
	void findByIdTest(){
		ComentarioVO comenta = Mockito.mock(ComentarioVO.class, Mockito.RETURNS_DEEP_STUBS);
		Mockito.when(comenta.getTextocomentario()).thenReturn("Texto test");
		Optional<ComentarioVO> listaComentarios = Optional.of(comenta);
		
		Mockito.when(comentarioRepo.findById(Mockito.any())).thenReturn(listaComentarios);
		Assertions.assertEquals("Texto test", comentarioService.findById(1).get().getTextocomentario());
	}
	
	


}
