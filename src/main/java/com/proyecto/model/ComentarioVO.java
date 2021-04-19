package com.proyecto.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comentarios")
public class ComentarioVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcomentario;
	private String textocomentario;
	private LocalDate fechacreacion;	
	
	@ManyToOne
	@JoinColumn(name="idpost")
	private PostVO post;
	
	@ManyToOne
	@JoinColumn(name="idusuario")
	private UsuarioVO usuarioComen;
	

	public ComentarioVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ComentarioVO(String textocomentario, LocalDate fechacreacion,
			PostVO post, UsuarioVO usuarioComen) {
		super();
		this.textocomentario = textocomentario;
		this.fechacreacion = fechacreacion;
		this.post = post;
		this.usuarioComen = usuarioComen;
	}

	public int getIdcomentario() {
		return idcomentario;
	}

	public void setIdcomentario(int idcomentario) {
		this.idcomentario = idcomentario;
	}

	public String getTextocomentario() {
		return textocomentario;
	}

	public void setTextocomentario(String textocomentario) {
		this.textocomentario = textocomentario;
	}

	public LocalDate getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(LocalDate fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public PostVO getPost() {
		return post;
	}

	public void setPost(PostVO post) {
		this.post = post;
	}

	public UsuarioVO getUsuarioComen() {
		return usuarioComen;
	}

	public void setUsuarioComen(UsuarioVO usuarioComen) {
		this.usuarioComen = usuarioComen;
	}





	

	
	
}
