package com.proyecto.model;

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
@Table(name="postfavoritos")
public class UsuarioPostFavoritoVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusuariopost", nullable = false)
	private Integer idusuariopost;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idusuario", nullable = false)
	private UsuarioVO usuarioFav;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idpost", nullable = false)
	private PostVO postFav;



	public Integer getIdusuariopost() {
		return idusuariopost;
	}

	public void setIdusuariopost(Integer idusuariopost) {
		this.idusuariopost = idusuariopost;
	}

	public UsuarioVO getUsuarioFav() {
		return usuarioFav;
	}

	public void setUsuarioFav(UsuarioVO usuario) {
		this.usuarioFav = usuario;
	}

	public PostVO getPostFav() {
		return postFav;
	}

	public void setPostFav(PostVO postFav) {
		this.postFav = postFav;
	}

	

}
