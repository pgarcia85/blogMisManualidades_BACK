package com.proyecto.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.model.RolVO;

@Repository
public interface RolRepository extends CrudRepository<RolVO, Long>{

	Optional<RolVO> findByDesrol(String name);
	
	
}
