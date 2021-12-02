package com.nttdata.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nttdata.models.Usuario;
import com.nttdata.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;

	
	@RequestMapping("/prueba")
	public String usuario() {
		return "usuario.jsp";
	}
	
	@RequestMapping("/CrearUsuario")
	public String login(Model model, @Valid @ModelAttribute Usuario usuario, BindingResult bindingResult, RedirectAttributes rm) {
		if(bindingResult.hasErrors()){
			List<String> errors = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
			rm.addFlashAttribute("errores", errors);
			return "redirect:/usuario";
		}
		model.addAttribute("usuario", usuario);
		usuarioService.insertarUsuario(usuario);
		System.out.println(usuario.getRut() + " " + usuario.getNombreCompleto() + " " + usuario.getPassword() + " " + usuario.getEmail());
		return "redirect:/usuario/lista";
	}
	
	
	@GetMapping("/registroLogin")
	public String registrarLogin(@ModelAttribute("usuario")Usuario usuario) {
		return "registroLogin.jsp";
	}
	
	
	@PostMapping("/registroLogin")
	public String registrar(@Valid @ModelAttribute("usuario")Usuario usuario,BindingResult bindingResult, RedirectAttributes rm){
		if(bindingResult.hasErrors()){
			List<String> errors = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
			rm.addFlashAttribute("errores", errors);
			return "redirect:/usuario/registroLogin";
		}
		Usuario usuario2 = usuarioService.findByEmail(usuario.getEmail());
		if(usuario2!=null) {
			System.out.println("usuario existe");
		}else {
			usuarioService.persistirUsuarioRol(usuario);
		}
		
		return "redirect:/";
	}
	
	/*
	 *
	
	@RequestMapping("/registrarInicio")
	public String registrar(Model model, @Valid @ModelAttribute Usuario usuario, BindingResult bindingResult, RedirectAttributes rm) {
		if(bindingResult.hasErrors()){
			List<String> errors = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
			rm.addFlashAttribute("errores", errors);
			return "redirect:/usuario/registroInicio";
		}
		model.addAttribute("usuario", usuario);
		usuarioService.registroUsuario(usuario);
		System.out.println(usuario.getRut() + " " + usuario.getNombreCompleto() + " " + usuario.getPassword() + " " + usuario.getEmail());
		
		
		return "redirect:/home";
	}
	 * 
	 */
	
	
	@RequestMapping("/ingresoLogin")
	public String ingresoLogin(Model model) {
		return "login.jsp";
	}
	/*
	http://localhost:8080/usuario/login
	*/
	//capturar la informacion del formulario
	@RequestMapping("/login")
	public String login(@RequestParam("email") String email,
			@RequestParam("password") String password,
			HttpSession session
			) 
	{
		boolean resultado = usuarioService.loginUsuario(email,password);
		if(resultado) {
			Usuario usuario = usuarioService.findByEmail(email);
			session.setAttribute("usuario_id", usuario.getId());
			session.setAttribute("nombreCompleto_Usuario", usuario.getNombreCompleto());
			return "redirect:/home";
		}else {
			return "redirect:/login";
		}
		
	}
	

	
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id) {
		if(usuarioService.existeUsuario(id)) {
			usuarioService.eliminarUsuario(id);
		}
		return "redirect:/usuario/lista";
	}
	
	//editar final
	@RequestMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Usuario usuario = usuarioService.obtenerUsuario(id);
		if(usuario!=null) {
			model.addAttribute("usuario", usuario);
			return "edicion.jsp";
		}
		return "redirect:/usuario/lista";
	}
	
	@RequestMapping("/editarUsuario")
	public String editarUsuario(@Valid @ModelAttribute Usuario usuario, BindingResult bindingResult, RedirectAttributes rm) {
		List<String> errors = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
		if(bindingResult.hasErrors()) {
			rm.addFlashAttribute("errores", errors);
			return "redirect:/usuario/editar/"+usuario.getId();
		}
		usuarioService.editarUsuario(usuario);
		return "redirect:/usuario/lista";
	}
	
	
	
	@RequestMapping("/lista")
	public String listar(Model model) {
		model.addAttribute("listaUsuarios", usuarioService.listarUsuarios());
		return "lista.jsp";
	}
	
	
	
	
	

	
}