package com.proyecto.service;

import java.util.Optional;

import com.proyecto.model.RolVO;

public interface RolService {
	
	Optional<RolVO> findByDesrol(String name);
	
	void deleteById(Long arg0);
	
	Iterable<RolVO> findAll();
	
	Optional<RolVO> findById(Long arg0);
	
	<S extends RolVO> S save(S arg0);

}
