package com.nttdata.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Producto;


@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {
	List<Producto> findAll();

	Optional<Producto> findById(Long id);
	
	@Query("SELECT p FROM Producto p where nombre=?1")
	List<Producto>  findBuscar(String nombre);
}
