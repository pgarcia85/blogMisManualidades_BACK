package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.model.ComentarioVO;
import com.proyecto.repository.ComentarioRepository;

@Service
public class ComentarioServiceImpl implements ComentarioService{
	
	
	@Autowired
	private ComentarioRepository comentarioRepo;

	@Override
	public List<ComentarioVO> findByIdpost(int idpost) {
		List<ComentarioVO> listaComentarios = comentarioRepo.findByPostIdpostOrderByFechacreacionAsc(idpost);
		return listaComentarios;
	}

	@Override
	public <S extends ComentarioVO> S save(S arg0) {	
		return comentarioRepo.save(arg0);
	}

	@Override
	public void deleteById(Integer arg0) {
		comentarioRepo.deleteById(arg0);
	}
	
	@Override
	public Optional<ComentarioVO> findById(Integer arg0) {
		return comentarioRepo.findById(arg0);
	}

	

}
