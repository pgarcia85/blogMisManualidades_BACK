package com.proyecto.model;

import java.time.LocalDate;
import java.util.List;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="post")
public class PostVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idpost;
	private String titulo;
	private String resumen;
	private String texto;
	private String imagen;
	private LocalDate fechacreacion;
	
	@OneToMany(mappedBy="post", cascade = { CascadeType.ALL })
	List<ComentarioVO> listaComentarios;
	
	@OneToMany(mappedBy="postFav", cascade = { CascadeType.ALL })
	private List<UsuarioPostFavoritoVO> usuariosFavorito;
	
	public PostVO() {
		super();
	}
	public PostVO(String titulo, String resumen, String texto, String imagen,
			LocalDate fechacreacion) {
		super();
		this.titulo = titulo;
		this.resumen = resumen;
		this.texto = texto;
		this.imagen = imagen;
		this.fechacreacion = fechacreacion;
	}
	public int getIdpost() {
		return idpost;
	}
	public void setIdpost(int idpost) {
		this.idpost = idpost;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getResumen() {
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public LocalDate getFechacreacion() {
		return fechacreacion;
	}
	public void setFechaCreacion(LocalDate fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fechacreacion == null) ? 0 : fechacreacion.hashCode());
		result = prime * result + idpost;
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result + ((resumen == null) ? 0 : resumen.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostVO other = (PostVO) obj;
		if (fechacreacion == null) {
			if (other.fechacreacion != null)
				return false;
		} else if (!fechacreacion.equals(other.fechacreacion))
			return false;
		if (idpost != other.idpost)
			return false;
		if (imagen == null) {
			if (other.imagen != null)
				return false;
		} else if (!imagen.equals(other.imagen))
			return false;
		if (resumen == null) {
			if (other.resumen != null)
				return false;
		} else if (!resumen.equals(other.resumen))
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PostVO [idpost=" + idpost + ", titulo=" + titulo + ", resumen="
				+ resumen + ", texto=" + texto + ", imagen=" + imagen
				+ ", fechaCreacion=" + fechacreacion + "]";
	}
	
	

}
