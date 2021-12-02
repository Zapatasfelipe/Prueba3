package com.nttdata.services;


import java.util.List;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.nttdata.models.Usuario;
import com.nttdata.repository.UsuarioRepository;

@Service

public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	RolService rolService;
	
	@Autowired
	BCryptPasswordEncoder bcpe;
	
	
	//buscar por email
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	//nuevo metedo bcpe
	public Usuario persistirUsuarioRol(Usuario usuario) {
		usuario.setPassword(bcpe.encode(usuario.getPassword()));
		usuario.setRoles(rolService.findByNombre("ROL_USER"));
		return usuarioRepository.save(usuario);
		
	}
	
	//insert usuario el primero
	public Usuario registroUsuario(Usuario usuario) {
		
		//hashear el password
		String password_hashed= BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
		//sobreescrbiir la password
		usuario.setPassword(password_hashed);
		
		return usuarioRepository.save(usuario);
	}
	
	
	
	public void insertarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	

	public boolean existeUsuario(Long id) {
		return usuarioRepository.existsById(id);
	}

	public void eliminarUsuario(Long id) {
		usuarioRepository.deleteById(id);
		
	}

	public Usuario obtenerUsuario(Long id) {
		return usuarioRepository.findById(id).get();
	}
	
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}



	public void editarUsuario(@Valid Usuario usuario) {
		usuarioRepository.save(usuario);
		
	}
	
	public boolean loginUsuario(String email, String password) {

		Usuario usuario = usuarioRepository.findByEmail(email);

		if (usuario == null) {
			return false;
		} else {
			// if(password.equals(usuario.getPassword())) {
			if (BCrypt.checkpw(password, usuario.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}

}
