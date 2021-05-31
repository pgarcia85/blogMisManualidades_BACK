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
import com.proyecto.repository.PostRepository;
import com.proyecto.service.EmailServiceImpl;
import com.proyecto.service.PostServiceImpl;

@SpringBootTest
public class PostServiceImplTest {
	
	@InjectMocks
	PostServiceImpl postServiceImpl;
	 
	@Mock
	PostRepository postRepository;
	
	@Before
	public void inicio() {
	   MockitoAnnotations.initMocks(this);   
	 }

	@Test
	void findAllTest() {
		List<PostVO> listaPost = new ArrayList<PostVO>();
		listaPost.add(new PostVO());
		listaPost.add(new PostVO());
		listaPost.add(new PostVO());
		Mockito.when(postRepository.findAllByOrderByFechacreacionAsc()).thenReturn(listaPost);
		
		List<PostVO> resultado = (List<PostVO>) postServiceImpl.findAllOrderByFechaCreacion();
		Assertions.assertEquals(3, resultado.size());
	}
	
	@Test
	void findByIdTest(){
		PostVO post = Mockito.mock(PostVO.class, Mockito.RETURNS_DEEP_STUBS);
		Mockito.when(post.getTitulo()).thenReturn("Titulo Post");
		Optional<PostVO> listaPost = Optional.of(post);
		
		Mockito.when(postRepository.findById(Mockito.any())).thenReturn(listaPost);
		Assertions.assertEquals("Titulo Post", postServiceImpl.findById(1).get().getTitulo());
	}
	
	
	@Test
	void savePostTest() {
		PostVO post = Mockito.mock(PostVO.class, Mockito.RETURNS_DEEP_STUBS);
		Mockito.when(post.getTitulo()).thenReturn("Titulo Post");
		
		Mockito.when(postRepository.save(Mockito.any())).thenReturn(post);
		
		Assertions.assertEquals("Titulo Post", postServiceImpl.save(new PostVO()).getTitulo());
	}

	@Test
	void deletePostTest() {
		
		postServiceImpl.deleteById(1);
		
	}


}
