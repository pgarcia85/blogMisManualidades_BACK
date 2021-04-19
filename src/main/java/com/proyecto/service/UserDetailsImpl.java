package com.proyecto.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proyecto.model.UsuarioVO;

public class UserDetailsImpl implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 561267057897762006L;

	private Long id;
	private String nombre;
	private String email;
	@JsonIgnore
	private String contrasena;
	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Long id, String nombre, String email, String contrasena,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.nombre= nombre;
		this.email = email;
		this.contrasena = contrasena;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(UsuarioVO usuario) {
		List<GrantedAuthority> authorities = null;
		
		try{
		authorities = usuario
				.getRoles()
				.stream()
				.map(rol -> new SimpleGrantedAuthority(rol.getRol().getDesrol()))
				.collect(Collectors.toList());
		
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		return new UserDetailsImpl(usuario.getIdusuario(), usuario.getNombre(), usuario.getEmail(),
				usuario.getContrasena(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {	
		return contrasena;
	}

	@Override
	public String getUsername() {	
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {	
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if(this==obj){
			return true;
		}
		if(obj==null || getClass()!= obj.getClass()){
			return false;
		}
		UserDetailsImpl usuario = (UserDetailsImpl) obj;
		return Objects.equals(id, usuario.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
