package com.proyecto.model;

import java.io.Serializable;

public class RolDTO{

	
	private Long idRol;
	private String desRol;
	
	
	public RolDTO() {
		super();
	}

	public RolDTO(Long idRol, String desRol) {
		super();
		this.idRol = idRol;
		this.desRol = desRol;
	}
	
	public Long getIdRol() {
		return idRol;
	}
	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}
	public String getDesRol() {
		return desRol;
	}
	public void setDesRol(String desRol) {
		this.desRol = desRol;
	}
}
