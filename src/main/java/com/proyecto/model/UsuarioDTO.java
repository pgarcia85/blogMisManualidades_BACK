package com.proyecto.model;

public class UsuarioDTO {
	
	private Long idusuario;
	private String nombre;
	private String apellidos;
	private String email;
	private int telefono;
	private String direccion;
	private String contrasena;
	
	//constructores
	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(String nombre, String apellidos, String email,
			int telefono, String direccion, String contrasena) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		this.contrasena = contrasena;
	}


	public UsuarioDTO(Long idusuario, String nombre, String apellidos,
			String email, int telefono, String direccion, String contrasena) {
		super();
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		this.contrasena = contrasena;
	}

	public Long getIdusuario() {
		return idusuario;
	}
	
	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	

}
