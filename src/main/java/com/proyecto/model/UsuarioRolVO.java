package com.proyecto.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuariosroles")
public class UsuarioRolVO {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "idusuariorol", nullable = false)
   private Integer idusuariorol;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "idusuario", nullable = false)
   private UsuarioVO usuario;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "idrol", nullable = false)
   private RolVO rol;

   
public UsuarioRolVO() {
	super();
}

public UsuarioRolVO(UsuarioVO usuario, RolVO rol) {
	super();
	this.usuario = usuario;
	this.rol = rol;
}
   
public Integer getIdusuariorol() {
	return idusuariorol;
}

public void setIdusuariorol(Integer idusuariorol) {
	this.idusuariorol = idusuariorol;
}

public UsuarioVO getUsuario() {
	return usuario;
}

public void setUsuario(UsuarioVO usuario) {
	this.usuario = usuario;
}

public RolVO getRol() {
	return rol;
}

public void setRol(RolVO rol) {
	this.rol = rol;
}

 
    
}