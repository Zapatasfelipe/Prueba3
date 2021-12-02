package com.nttdata.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Producto;
import com.nttdata.repository.ProductoRepository;


@Service
public class ProductoService {
	@Autowired
	ProductoRepository productoRepository;
	
	
	public void insertarProducto(Producto producto) {
		productoRepository.save(producto);
	}
	

	public List<Producto> listarProductos() {
		return productoRepository.findAll();
	}


	public boolean existeProducto(Long id) {
		
		return productoRepository.existsById(id);
	}


	public void eliminarProducto(Long id) {
		productoRepository.deleteById(id);
		
	}


	public Producto obtenerProducto(Long id) {
		
		return productoRepository.findById(id).get();
	}


	public void editarProducto(@Valid Producto producto) {
		productoRepository.save(producto);
		
	}
	
	
	public List<Producto> findBuscar(String nombre){
		return productoRepository.findBuscar(nombre);
	}
}
