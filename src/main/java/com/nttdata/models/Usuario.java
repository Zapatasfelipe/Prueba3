package com.nttdata.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "usuarios")

public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String rut;
	@NotEmpty(message="El Nombre es obligatorio")
	private String nombreCompleto;
	
	
	private String password;
	
	@NotEmpty(message="El Correo es obligatorio")
	private String email;
	
	@Transient
	private String passwordConfirmation;
	
	// relacion many to many
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "roles_usuarios", // tabla intermedia
			joinColumns = @JoinColumn(name = "usuario_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))

	private List<Role> roles;
	

	public Usuario() {
		super();
	}
	
	

	public Usuario(String rut, @NotEmpty(message = "El Nombre es obligatorio") String nombreCompleto, String password,
			@NotEmpty(message = "El Correo es obligatorio") String email, String passwordConfirmation,
			List<Role> roles) {
		super();
		this.rut = rut;
		this.nombreCompleto = nombreCompleto;
		this.password = password;
		this.email = email;
		this.passwordConfirmation = passwordConfirmation;
		this.roles = roles;
	}



	public Usuario(Long id, String rut, String nombreCompleto, String password, String email) {
		super();
		this.id = id;
		this.rut = rut;
		this.nombreCompleto = nombreCompleto;
		this.password = password;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
}
