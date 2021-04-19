package com.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.proyecto.model.UsuarioVO;
import com.proyecto.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		UsuarioVO usuario = usuarioRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("No encontrado usuario con email: "+email));
	
	return UserDetailsImpl.build(usuario);
	}

}
