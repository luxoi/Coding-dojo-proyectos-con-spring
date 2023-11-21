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
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="el campo de nombre es obligatorio.")
	@Size(min=2, message="el nombre debe tener almenos 2 caracteres.")
	private String nombre;
	
	@NotEmpty(message="el campo de apellido es obligatorio.")
	@Size(min=2, message="el nombre debe tener almenos 2 caracteres.")
	private String apellido;
	
	@NotEmpty(message="el campo de email es obligatorio.")
	@Email(message="Ingresa un correo valido")
	private String email;

	@NotEmpty(message="El campo de password es obligatoro")
	@Size(min=6, message="La contraseña debe tener almenos 6 caracteres")
	private String password;
	
	@Transient
	@NotEmpty(message="El campo de confirmacion es obligatoro")
	@Size(min=6, message="La contraseña debe tener almenos 6 caracteres")
	private String confirmacion;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@NotEmpty(message="La ubicacion es obligatoria")
	private String ubicacion;
	
	@NotEmpty(message="El estado es obligatorio")
	private String estado;

	@OneToMany(mappedBy="host", fetch=FetchType.LAZY)
	private List<Evento> eventosPlaneados;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="usuarios_asisten_eventos",
			joinColumns = @JoinColumn(name="usuario_id"),
			inverseJoinColumns = @JoinColumn(name="evento_id")
			)
	private List<Evento> eventosAsistidos;
	
	
	@OneToMany(mappedBy = "autor", fetch=FetchType.LAZY)
	private List<Mensaje> mensajes;
	
	
	public Usuario() {
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmacion() {
		return confirmacion;
	}

	public void setConfirmacion(String confirmacion) {
		this.confirmacion = confirmacion;
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
	public List<Evento> getEventosPlaneados() {
		return eventosPlaneados;
	}

	public void setEventosPlaneados(List<Evento> eventosPlaneados) {
		this.eventosPlaneados = eventosPlaneados;
	}

	public List<Evento> getEventosAsistidos() {
		return eventosAsistidos;
	}

	public void setEventosAsistidos(List<Evento> eventosAsistidos) {
		this.eventosAsistidos = eventosAsistidos;
	}

	public List<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
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
