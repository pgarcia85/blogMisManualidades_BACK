package com.proyecto.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.proyecto.model.PostVO;

@Repository
public interface PostRepository extends CrudRepository<PostVO, Integer>{

}
