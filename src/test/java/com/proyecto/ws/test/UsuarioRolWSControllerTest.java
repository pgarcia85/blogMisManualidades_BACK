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

import com.proyecto.model.RolVO;
import com.proyecto.model.UsuarioRolDTO;
import com.proyecto.model.UsuarioRolVO;
import com.proyecto.model.UsuarioVO;
import com.proyecto.service.RolService;
import com.proyecto.service.UsuarioRolService;
import com.proyecto.service.UsuarioService;
import com.proyecto.ws.UsuarioRolWSContoller;

@SpringBootTest
public class UsuarioRolWSControllerTest {

	@InjectMocks
	UsuarioRolWSContoller usuarioRolWSController;

	@Mock
	UsuarioRolService usuarioRolService;

	@Mock
	UsuarioService usuarioService;

	@Mock
	RolService rolService;

	@Before
	public void inicio() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void UsuarioRolWSContoller() {
		List<UsuarioRolVO> listaUsuarioRol = new ArrayList<>();
		listaUsuarioRol.add(Mockito.mock(UsuarioRolVO.class,
				Mockito.RETURNS_DEEP_STUBS));
		listaUsuarioRol.add(Mockito.mock(UsuarioRolVO.class,
				Mockito.RETURNS_DEEP_STUBS));

		Mockito.when(
				usuarioRolService.findByUsuarioIdusuario(Mockito.anyLong()))
				.thenReturn(listaUsuarioRol);

		Assertions.assertEquals(2, usuarioRolWSController.getRolesUsuario(1L)
				.size());
	}

	@Test
	public void eliminarUsuarioRolTest() {
		UsuarioRolDTO usuarioRolDTO = Mockito.mock(UsuarioRolDTO.class,
				Mockito.RETURNS_DEEP_STUBS);

		UsuarioVO usuario = Mockito.mock(UsuarioVO.class,
				Mockito.RETURNS_DEEP_STUBS);
		Optional<UsuarioVO> listaUsu = Optional.of(usuario);
		Mockito.when(usuarioService.findById(Mockito.anyLong())).thenReturn(
				listaUsu);

		RolVO rol = Mockito.mock(RolVO.class, Mockito.RETURNS_DEEP_STUBS);
		Optional<RolVO> listaRol = Optional.of(rol);
		Mockito.when(rolService.findById(Mockito.anyLong())).thenReturn(
				listaRol);

		UsuarioRolVO usuarioRolVO = Mockito.mock(UsuarioRolVO.class,
				Mockito.RETURNS_DEEP_STUBS);
		Optional<UsuarioRolVO> lista = Optional.of(usuarioRolVO);
		Mockito.when(
				usuarioRolService.findByUsuarioIdusuarioAndRolIdrol(
						Mockito.anyLong(), Mockito.anyLong()))
				.thenReturn(lista);

		Assertions.assertEquals(200,
				usuarioRolWSController.eliminarUsuarioRol(usuarioRolDTO)
						.getStatusCodeValue());
	}

	@Test
	public void guardarUsuarioRolTest() {
		UsuarioRolDTO usuarioRolDTO = Mockito.mock(UsuarioRolDTO.class,
				Mockito.RETURNS_DEEP_STUBS);

		UsuarioVO usuario = Mockito.mock(UsuarioVO.class,
				Mockito.RETURNS_DEEP_STUBS);
		Optional<UsuarioVO> listaUsu = Optional.of(usuario);
		Mockito.when(usuarioService.findById(Mockito.anyLong())).thenReturn(
				listaUsu);

		RolVO rol = Mockito.mock(RolVO.class, Mockito.RETURNS_DEEP_STUBS);
		Optional<RolVO> listaRol = Optional.of(rol);
		Mockito.when(rolService.findById(Mockito.anyLong())).thenReturn(
				listaRol);

		Assertions.assertEquals(200,
				usuarioRolWSController.guardarUsuarioRol(usuarioRolDTO)
						.getStatusCodeValue());
	}
}
