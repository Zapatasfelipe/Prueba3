package com.nttdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Categoria;
import com.nttdata.repository.CategoriaRepository;


@Service
public class CategoriaService {
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public void insertarCategoria(Categoria categoria) {
		categoriaRepository.save(categoria);
	}
	
	public List<Categoria> listarCategorias() {
		return categoriaRepository.findAll();
	}
	
	public boolean existeCategoria(Long id) {
		return categoriaRepository.existsById(id);
	}

	public void eliminarCategoria(Long id) {
		categoriaRepository.deleteById(id);
		
	}
	
	
	
}
