package com.proyecto.model;

import java.time.LocalDate;

public class PostDTO {
	
	
private int idpost;
private String titulo;
private String resumen;
private String texto;
private String imagen;
private LocalDate fechacreacion;


public PostDTO() {
	super();
	// TODO Auto-generated constructor stub
}
public PostDTO(int idpost, String titulo, String resumen, String texto,
		String imagen, LocalDate fechacreacion) {
	super();
	this.idpost = idpost;
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
public LocalDate getFechaCreacion() {
	return fechacreacion;
}
public void setFechaCreacion(LocalDate fechacreacion) {
	this.fechacreacion = fechacreacion;
}



}
