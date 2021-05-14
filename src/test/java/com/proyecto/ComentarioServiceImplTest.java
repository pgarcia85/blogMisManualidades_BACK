package com.proyecto;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.proyecto.model.ComentarioVO;
import com.proyecto.model.PostVO;
import com.proyecto.model.UsuarioVO;
import com.proyecto.repository.ComentarioRepository;
import com.proyecto.repository.PostRepository;
import com.proyecto.repository.UsuarioRepository;
import com.proyecto.service.PostService;

@SpringBootTest
public class ComentarioServiceImplTest {
	
	@Autowired
	 static ComentarioRepository comentarioRepo;
	
	@Autowired
	 static PostService postService;
	
	@Autowired
	static UsuarioRepository usuarioRepository;
	

    private static ComentarioVO comentario ;
	
	@BeforeAll
	public static void init(){
		ComentarioVO comentario = new ComentarioVO();
		comentario.setFechacreacion(LocalDate.now());
		comentario.setTextocomentario("Prueba Test");
		
		UsuarioVO usuario = new UsuarioVO();
		usuario.setNombre("nombre");
		usuario.setApellidos("apellido");
		usuario.setDireccion("Direccion");
		usuario.setEmail("Email");
		usuario.setContrasena("contraseña");
		usuario.setTelefono(663785426);
		
		comentario.setUsuarioComen(usuario);
		
		PostVO post = postService.findById(1).get();
		comentario.setPost(post);	
		
	}
		
	
	@Test
	void findByIdpostTest() {
		List<ComentarioVO> listaComentarios = comentarioRepo.findByPostIdpostOrderByFechacreacionAsc(1);
		Assertions.assertEquals(2, listaComentarios.size());
	}
	
	@Test
	void saveComentarioTest() {
		
		ComentarioVO comenta = comentarioRepo.save(comentario);
		Assertions.assertEquals("Prueba Test", comenta.getTextocomentario());
	}

	@Test
	void deleteComentarioTest() {
		
		comentarioRepo.deleteById(comentario.getIdcomentario());
		
	}

	
	


}
