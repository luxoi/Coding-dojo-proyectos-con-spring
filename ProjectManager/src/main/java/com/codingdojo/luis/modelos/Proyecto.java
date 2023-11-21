package com.codingdojo.luis.modelos;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="proyectos")
public class Proyecto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message="el campo de titulo es obligatorio.")
	@Size(min=3, message="el nombre debe tener almenos 2 caracteres.")
	private String titulo;
	@NotEmpty(message="el campo de descripcion es obligatorio.")
	@Size(min=3, message="la descripcion  debe tener almenos 3 caracteres.")
	private String descripcion;
	@NotNull(message="la fecha no puede ser vacia")
	@Future
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecha;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_id")
	private Usuario lider;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="proyectos_con_usuarios",
			joinColumns = @JoinColumn(name="proyecto_id"),
			inverseJoinColumns = @JoinColumn(name="usuario_id")
			)
	private List<Usuario> usuariosUnidos;
	
	
	public Usuario getLider() {
		return lider;
	}
	public void setLider(Usuario lider) {
		this.lider = lider;
	}
	public Proyecto() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<Usuario> getUsuariosUnidos() {
		return usuariosUnidos;
	}
	public void setUsuariosUnidos(List<Usuario> usuariosUnidos) {
		this.usuariosUnidos = usuariosUnidos;
	}
	@PrePersist //Antes de hacer la creación
	protected void onCreate() {
		this.createdAt = new Date(); //DEFAULT CURRENT_TIMESTAMP
	}
	
	@PreUpdate //Antes de hacer una actualización
	protected void onUpdate() {
		this.updatedAt = new Date(); //DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
	}
}
