package com.proyecto.model;

import java.time.LocalDate;

public class ComentarioDTO {
	
	private int idComentario;
	private String texto;
	private LocalDate fechaCreacion;
	private int idPost;
	private String nombreUsuario;
	private long idUsuario;

	public ComentarioDTO() {
		super();
		
	}
	
	public ComentarioDTO(int idComentario, String texto,
			LocalDate fechaCreacion, String nombreUsuario) {
		super();
		this.idComentario = idComentario;
		this.texto = texto;
		this.fechaCreacion = fechaCreacion;
		this.nombreUsuario = nombreUsuario;
	}

	public ComentarioDTO(int idComentario, String texto,
			LocalDate fechaCreacion, int idPost, String nombreUsuario,
			long idUsuario) {
		super();
		this.idComentario = idComentario;
		this.texto = texto;
		this.fechaCreacion = fechaCreacion;
		this.idPost = idPost;
		this.nombreUsuario = nombreUsuario;
		this.idUsuario = idUsuario;
	}



	public ComentarioDTO(String texto, LocalDate fechaCreacion, int idPost,
			long idUsuario) {
		super();
		this.texto = texto;
		this.fechaCreacion = fechaCreacion;
		this.idPost = idPost;
		this.idUsuario = idUsuario;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getIdPost() {
		return idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	

}
