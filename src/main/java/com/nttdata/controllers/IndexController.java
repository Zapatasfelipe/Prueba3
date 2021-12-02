package com.nttdata.controllers;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.nttdata.services.UsuarioService;



@Controller
public class IndexController {

	
	@Autowired
	UsuarioService usuarioService;

	
	@RequestMapping("/")
		public String home() {
		return "index.jsp";
	}
	
	@RequestMapping("/login")
	public String login() {
	return "login.jsp";
}
	
	@RequestMapping("/home")
	public String inicioHome(HttpSession session,Model model) {
		String nombre = (String) session.getAttribute("nombreCompleto_Usuario");
		Long usuario_id= (Long) session.getAttribute("usuario_id");
		
		model.addAttribute("nombreCompleto_usuario", nombre);
		model.addAttribute("usuario_id", usuario_id);
	return "home.jsp";
}
	

}
	
	

