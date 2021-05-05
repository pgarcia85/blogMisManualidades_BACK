package com.proyecto.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="usuarios", uniqueConstraints={@UniqueConstraint(columnNames="email"),@UniqueConstraint(columnNames="contrasena")})
public class UsuarioVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idusuario;
	private String nombre;
	private String apellidos;
	private String email;
	private int telefono;
	private String direccion;
	private String contrasena;
	
	@OneToMany(mappedBy="usuarioComen",fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	List<ComentarioVO> listaComentarios;
	
	@OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private List<UsuarioRolVO> roles;
	
	@OneToMany(mappedBy = "usuarioFav",fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private List<UsuarioPostFavoritoVO> postFavoritos;
	

	public UsuarioVO() {
		super();
	}

	public UsuarioVO(String nombre, String apellidos, String email,
			int telefono, String direccion, String contrasena) {
		super();
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

	public List<ComentarioVO> getListaComentarios() {
		return listaComentarios;
	}

	public void setListaComentarios(List<ComentarioVO> listaComentarios) {
		this.listaComentarios = listaComentarios;
	}

	public List<UsuarioRolVO> getRoles() {
		return roles;
	}

	public void setRoles(List<UsuarioRolVO> roles) {
		this.roles = roles;
	}

	public List<UsuarioPostFavoritoVO> getPostFavoritos() {
		return postFavoritos;
	}

	public void setPostFavoritos(List<UsuarioPostFavoritoVO> postFavoritos) {
		this.postFavoritos = postFavoritos;
	}
	
	

}
