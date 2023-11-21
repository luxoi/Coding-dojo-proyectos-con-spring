package com.codingdojo.luis.Modelos;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="eventos")
public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@NotEmpty(message="el campo de nombre es obligatorio.")
	@Size(min=2, message="el nombre debe tener almenos 2 caracteres.")
	private String nombre;
	
	@Future
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message="Fecha no puede estar vacia")
	private Date fecha;
	
	@NotEmpty(message="el campo de ubicacion es obligatorio.")
	private String ubicacion;
	
	@NotEmpty(message="el campo de estado es obligatorio.")
	private String estado;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_id")
	private Usuario host;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="usuarios_asisten_eventos",
			joinColumns= @JoinColumn(name="evento_id"),
			inverseJoinColumns = @JoinColumn(name="usuario_id")
			)
	private List<Usuario> asistentes;
	
	@OneToMany(mappedBy = "evento", fetch=FetchType.LAZY)
	private List<Mensaje> mensajesEvento;
	
	
	public Evento() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public Usuario getHost() {
		return host;
	}

	public void setHost(Usuario host) {
		this.host = host;
	}

	public List<Usuario> getAsistentes() {
		return asistentes;
	}

	public void setAsistentes(List<Usuario> asistentes) {
		this.asistentes = asistentes;
	}

	public List<Mensaje> getMensajesEvento() {
		return mensajesEvento;
	}

	public void setMensajesEvento(List<Mensaje> mensajesEvento) {
		this.mensajesEvento = mensajesEvento;
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
