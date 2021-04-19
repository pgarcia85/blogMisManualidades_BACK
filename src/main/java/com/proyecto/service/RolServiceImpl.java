package com.proyecto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.model.RolVO;
import com.proyecto.repository.RolRepository;

@Service
public class RolServiceImpl implements RolService{
	
	@Autowired
	private RolRepository rolRepository;

	@Override
	public Optional<RolVO> findByDesrol(String name) {
		
		return rolRepository.findByDesrol(name);
	}

	@Override
	public void deleteById(Long arg0) {
		rolRepository.deleteById(arg0);
	}

	@Override
	public Iterable<RolVO> findAll() {
		return rolRepository.findAll();	
	}
	
	@Override
	public Optional<RolVO> findById(Long arg0) {
		return rolRepository.findById(arg0);
	}

	@Override
	public <S extends RolVO> S save(S arg0) {
		return rolRepository.save(arg0);
	}

}
