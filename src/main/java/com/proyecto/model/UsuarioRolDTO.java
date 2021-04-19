package com.proyecto.model;

public class UsuarioRolDTO {
	
	private Integer idusuariorol;
	
	private Long idusuario;
	
	private String nombreUsuario;
	
	private Long idrol;
	
	private String desrol;
	

	public UsuarioRolDTO() {
		super();
		
	}

	public UsuarioRolDTO(Long idusuario, Long idrol) {
		super();
		this.idusuario = idusuario;
		this.idrol = idrol;
	}
	
	

	public UsuarioRolDTO(Long idusuario, String nombreUsuario, Long idrol,
			String desrol) {
		super();
		this.idusuario = idusuario;
		this.nombreUsuario = nombreUsuario;
		this.idrol = idrol;
		this.desrol = desrol;
	}

	public Integer getIdusuariorol() {
		return idusuariorol;
	}

	public void setIdusuariorol(Integer idusuariorol) {
		this.idusuariorol = idusuariorol;
	}

	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Long getIdrol() {
		return idrol;
	}

	public void setIdrol(Long idrol) {
		this.idrol = idrol;
	}

	public String getDesrol() {
		return desrol;
	}

	public void setDesrol(String desrol) {
		this.desrol = desrol;
	}


	 
	 

}
