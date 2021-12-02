package com.nttdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Venta;
import com.nttdata.repository.VentaRepository;

@Service
public class VentaService {
	@Autowired
	VentaRepository ventaRepository;

	public void insertarVenta(Venta venta) {
		ventaRepository.save(venta);
		
	}

	public List<Venta> listarVentas() {
		return ventaRepository.findAll();
	}

	public boolean existeVenta(Long id) {
		return ventaRepository.existsById(id);
	}

	public void eliminarVenta(Long id) {
		ventaRepository.deleteById(id);
		
	}
	
	public void eliminarTodos(Long id) {
		ventaRepository.deleteAll();
		
	}
	
	public boolean existeVentaTodos(Long id) {
		return ventaRepository.existsById(id);
	}
	
	
}
