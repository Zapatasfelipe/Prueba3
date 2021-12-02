package com.nttdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Role;
import com.nttdata.repository.RolRepository;

@Service
public class RolService {

	@Autowired
	RolRepository rr;
	
	public List<Role>findByNombre(String nombre){
		return rr.findByNombre(nombre);
	}
}
