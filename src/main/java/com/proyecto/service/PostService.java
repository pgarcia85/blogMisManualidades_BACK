package com.proyecto.service;

import java.util.Optional;

import com.proyecto.model.PostVO;

public interface PostService {

	Iterable<PostVO> findAllOrderByFechaCreacion();

	Optional<PostVO> findById(Integer arg0);

	void deleteById(Integer arg0);

	<S extends PostVO> S save(S arg0);

}
