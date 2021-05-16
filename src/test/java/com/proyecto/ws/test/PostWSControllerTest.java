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

import com.proyecto.model.ComentarioVO;
import com.proyecto.model.PostDTO;
import com.proyecto.model.PostVO;
import com.proyecto.request.UpdatePostRequest;
import com.proyecto.service.PostService;
import com.proyecto.ws.PostWSController;


@SpringBootTest
public class PostWSControllerTest {
	
	@InjectMocks
	PostWSController postWSController;
	
	@Mock
	PostService postService;
	
	@Before
	public void inicio() {
	   MockitoAnnotations.initMocks(this);   
	 }
	
	
	@Test
	public void getListaPostTest(){
		List<PostVO> listaPost = new ArrayList<PostVO>();
		listaPost.add(Mockito.mock(PostVO.class, Mockito.RETURNS_DEEP_STUBS));
		listaPost.add(Mockito.mock(PostVO.class, Mockito.RETURNS_DEEP_STUBS));
		listaPost.add(Mockito.mock(PostVO.class, Mockito.RETURNS_DEEP_STUBS));
		Mockito.when(postService.findAll()).thenReturn(listaPost);
			
		
		Assertions.assertEquals(3, postWSController.getListaPost().size());
	}
	
	@Test
	public void getPostTest(){
		PostVO post = Mockito.mock(PostVO.class, Mockito.RETURNS_DEEP_STUBS);
		Mockito.when(post.getResumen()).thenReturn("resumen");
		Optional<PostVO> lista = Optional.of(post);
			
		Mockito.when(postService.findById(Mockito.anyInt())).thenReturn(lista);
			
		Assertions.assertEquals("resumen", postWSController.getPost(1).getResumen());
	}
	
	@Test
	public void insertaPostTest(){
		PostDTO post = Mockito.mock(PostDTO.class, Mockito.RETURNS_DEEP_STUBS);
		
		Assertions.assertEquals(200, postWSController.insertaPost(post).getStatusCodeValue());
	}
	
	@Test
	public void eliminaPostTest(){
		
		Assertions.assertEquals(200, postWSController.eliminaPost(1).getStatusCodeValue());
	}
	
	@Test
	public void updatePostTest(){
		UpdatePostRequest request = Mockito.mock(UpdatePostRequest.class, Mockito.RETURNS_DEEP_STUBS);
		PostVO post = Mockito.mock(PostVO.class, Mockito.RETURNS_DEEP_STUBS);
		Optional<PostVO> lista = Optional.of(post);
		
		Mockito.when(postService.findById(Mockito.anyInt())).thenReturn(lista);
		
		Assertions.assertEquals(200, postWSController.updatePost(request).getStatusCodeValue());
	}

}
