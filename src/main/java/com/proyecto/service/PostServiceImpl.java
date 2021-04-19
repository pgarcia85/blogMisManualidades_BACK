package com.proyecto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.model.PostVO;
import com.proyecto.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public Iterable<PostVO> findAll() {		
		return postRepository.findAll();
	}

	@Override
	public Optional<PostVO> findById(Integer arg0) {
		return postRepository.findById(arg0);
	}

	@Override
	public void deleteById(Integer arg0) {
		postRepository.deleteById(arg0);
	}

	@Override
	public <S extends PostVO> S save(S arg0) {
		return postRepository.save(arg0);
	}

}
