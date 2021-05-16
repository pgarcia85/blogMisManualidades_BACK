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

import com.proyecto.model.RolDTO;
import com.proyecto.model.RolVO;
import com.proyecto.service.RolService;
import com.proyecto.ws.RolWSController;

@SpringBootTest
public class RolWSControllerTest {

	@InjectMocks
	RolWSController rolWSController;

	@Mock
	RolService rolService;

	@Before
	public void inicio() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getListaRolesTest() {
		List<RolVO> listaRol = new ArrayList<RolVO>();
		listaRol.add(new RolVO());
		listaRol.add(new RolVO());
		Mockito.when(rolService.findAll()).thenReturn(listaRol);

		Assertions.assertEquals(2, rolWSController.getListaRoles().size());
	}

	@Test
	public void getRolTest() {
		RolVO rol = Mockito.mock(RolVO.class, Mockito.RETURNS_DEEP_STUBS);
		Mockito.when(rol.getDesrol()).thenReturn("Registrado");
		Optional<RolVO> listaRol = Optional.of(rol);

		Mockito.when(rolService.findById(Mockito.anyLong())).thenReturn(
				listaRol);

		Assertions.assertEquals("Registrado", rolWSController.getRol(1L).getDesRol());
	}
	
	@Test
	public void insertaRolTest(){
		RolDTO rolDTO = Mockito.mock(RolDTO.class, Mockito.RETURNS_DEEP_STUBS);		
		RolVO rol = Mockito.mock(RolVO.class, Mockito.RETURNS_DEEP_STUBS);
		Mockito.when(rolService.save(Mockito.any())).thenReturn(rol);
		
		Assertions.assertEquals(200, rolWSController.insertaRol(rolDTO).getStatusCodeValue());
	}
	
	@Test
	public void eliminaRolTest(){
		
		Assertions.assertEquals(200, rolWSController.eliminaRol(1L).getStatusCodeValue());
	}
	
	@Test
	public void updateRolTest() {
		RolDTO rolDTO = Mockito.mock(RolDTO.class, Mockito.RETURNS_DEEP_STUBS);
		
		RolVO rol = Mockito.mock(RolVO.class, Mockito.RETURNS_DEEP_STUBS);
		Mockito.when(rol.getDesrol()).thenReturn("Registrado");
		Optional<RolVO> listaRol = Optional.of(rol);

		Mockito.when(rolService.findById(Mockito.anyLong())).thenReturn(
				listaRol);

		Assertions.assertEquals(200, rolWSController.updateRol(rolDTO).getStatusCodeValue());
	}
	
}