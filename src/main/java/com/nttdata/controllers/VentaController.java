package com.nttdata.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nttdata.models.Venta;
import com.nttdata.services.ProductoService;
import com.nttdata.services.UsuarioService;
import com.nttdata.services.VentaService;

@Controller
@RequestMapping("/venta")
public class VentaController {
	@Autowired
	VentaService ventaService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	ProductoService productoService;
	
	@RequestMapping("")
	public String venta(Model model) {
		model.addAttribute("listaProductos", productoService.listarProductos());
		model.addAttribute("listaUsuario", usuarioService.listarUsuarios());
		return "venta.jsp";
	}
	
	
	@RequestMapping("/createVenta")
	public String login(Model model, @Valid @ModelAttribute Venta venta, BindingResult bindingResult, RedirectAttributes rm) {
		if(bindingResult.hasErrors()){
			List<String> errors = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
			rm.addFlashAttribute("errores", errors);
			return "redirect:/venta";
		}
		model.addAttribute("venta", venta);
		ventaService.insertarVenta(venta);
		System.out.println(venta.getCantidad());
		return "redirect:/venta/listaVenta";
	}
	

	
	@RequestMapping("/listaVenta")
	public String listar(Model model) {
		model.addAttribute("listaVentas", ventaService.listarVentas());
		model.addAttribute("listaUsuario", usuarioService.listarUsuarios());
		return "listaVenta.jsp";
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id) {
		if(ventaService.existeVenta(id)) {
			ventaService.eliminarVenta(id);
		}
		return "redirect:/venta/listaVenta";
	}
	
	@RequestMapping("/eliminarTodos")
	public String eliminarTodos(@PathVariable Long id) {
		if(ventaService.existeVentaTodos(id)) {
			ventaService.eliminarTodos(id);
		}
		return "redirect:/venta/listaVenta";
	}
}
