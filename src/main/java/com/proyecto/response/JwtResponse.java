package com.proyecto.response;

import java.util.List;

public class JwtResponse {
	
	private String token;
	private String type="Bearer";
	private Long id;
	private String nombre;
	private String email;
	private String constrasena;
	private List<String> roles;

	public JwtResponse(String token, Long id, String nombre, String email,
			String constrasena, List<String> roles) {
		super();
		this.token = token;
		this.id = id;
		this.nombre=nombre;
		this.email = email;
		this.constrasena = constrasena;
		this.roles = roles;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getConstrasena() {
		return constrasena;
	}
	public void setConstrasena(String constrasena) {
		this.constrasena = constrasena;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	

}
