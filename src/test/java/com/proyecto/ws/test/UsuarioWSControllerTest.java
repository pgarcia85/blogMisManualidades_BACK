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

import com.proyecto.model.UsuarioVO;
import com.proyecto.request.UpdateUsuarioRequest;
import com.proyecto.service.UsuarioService;
import com.proyecto.ws.UsuarioWSContoller;


@SpringBootTest
public class UsuarioWSControllerTest {
	
	@InjectMocks
	UsuarioWSContoller usuarioWSContoller;	
	
	@Mock
	UsuarioService usuarioService;
	
	
	@Before
	public void inicio() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getDatosUsuarioTest(){
			
		UsuarioVO usuario = Mockito.mock(UsuarioVO.class, Mockito.RETURNS_DEEP_STUBS);
		Mockito.when(usuario.getNombre()).thenReturn("Nuria");
		Optional<UsuarioVO> listaUsu = Optional.of(usuario);
		Mockito.when(usuarioService.findById(Mockito.anyLong())).thenReturn(listaUsu);
		
		Assertions.assertEquals("Nuria", usuarioWSContoller.getDatosUsuario(1L).getNombre());
	}
	
	@Test
	public void updateUsuarioTest(){
		UpdateUsuarioRequest request = Mockito.mock(UpdateUsuarioRequest.class, Mockito.RETURNS_DEEP_STUBS);
		
		UsuarioVO usuario = Mockito.mock(UsuarioVO.class, Mockito.RETURNS_DEEP_STUBS);
		Optional<UsuarioVO> listaUsu = Optional.of(usuario);
		Mockito.when(usuarioService.findById(Mockito.anyLong())).thenReturn(listaUsu);
		
		Assertions.assertEquals(200, usuarioWSContoller.updateUsuario(request).getStatusCodeValue());
		
	}
	
	@Test
	public void eliminarUsuarioTest(){
		
		Assertions.assertEquals(200, usuarioWSContoller.eliminarUsuario(1L).getStatusCodeValue());
		
	}
	
	@Test
	public void eliminarUsuarioErrorTest(){
		
		Mockito.doThrow(NullPointerException.class).when(usuarioService).deleteById(Mockito.anyLong());
		
		Assertions.assertEquals(400, usuarioWSContoller.eliminarUsuario(1L).getStatusCodeValue());
		
	}
	
	
	@Test
	public void getUsuariosTest(){
			
		List<UsuarioVO> lista = new ArrayList<>();
		lista.add(Mockito.mock(UsuarioVO.class, Mockito.RETURNS_DEEP_STUBS));
		lista.add(Mockito.mock(UsuarioVO.class, Mockito.RETURNS_DEEP_STUBS));
		
		Mockito.when(usuarioService.findByRolesRolIdrol(Mockito.anyLong())).thenReturn(lista);
		
		Assertions.assertEquals(2, usuarioWSContoller.getUsuarios().size());
	}

}
