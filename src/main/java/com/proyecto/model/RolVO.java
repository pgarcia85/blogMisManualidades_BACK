package com.proyecto.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Entity
@Table(name = "roles")
public class RolVO {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrol", nullable = false)
    private Long idrol;
 
    @Column(name = "desrol", length = 45, nullable = false)
    private String desrol;
 
    @OneToMany(mappedBy="rol",fetch=FetchType.LAZY,cascade= {CascadeType.ALL})
	private List<UsuarioRolVO> usuarios;
    
    

    public RolVO() {
		super();		
	}

	public RolVO(String desrol) {
		super();
		this.desrol = desrol;
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

	public List<UsuarioRolVO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioRolVO> usuarios) {
		this.usuarios = usuarios;
	}

	
    
}