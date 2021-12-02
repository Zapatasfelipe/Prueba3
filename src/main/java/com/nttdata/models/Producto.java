package com.nttdata.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;



@Entity
@Table(name = "productos")

public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="El Nombre es obligatorio")
	private String nombre;
	@NotEmpty(message="El Nombre es obligatorio")
	private String marca;
	
	@NotEmpty(message="La descripcion es obligatorio")
	@Size(min = 10, max = 100, message = "La descripcion deber ser de mas de 10 caracteres")
	private String descripcion;
	
	
	private Integer precio;
	

	//relacion many to many
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name="categorias_productos",//tabla intermedia
		joinColumns = @JoinColumn(name="producto_id"),
		inverseJoinColumns = @JoinColumn(name="categoria_id")
	)
	private List<Categoria> categorias;
	
	//relacion many to many
		@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(
			name="ventas_productos",//tabla intermedia
			joinColumns = @JoinColumn(name="producto_id"),
			inverseJoinColumns = @JoinColumn(name="venta_id")
		)
		private List<Venta> ventas;
	
	public Producto() {
		super();
	}

	public Producto(Long id, String nombre, String marca, String descripcion, Integer precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
		this.descripcion = descripcion;
		this.precio = precio;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	
	
	
	
	
	
	
	
	
}
