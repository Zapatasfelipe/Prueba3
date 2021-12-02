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

import com.nttdata.models.Producto;
import com.nttdata.services.CategoriaService;
import com.nttdata.services.ProductoService;

@Controller
@RequestMapping("/producto")

public class ProductoController {
	@Autowired
	ProductoService productoService;
	
	@Autowired
	CategoriaService categoriaService;
	
	
	@RequestMapping("")
	public String producto(Model model) {
		model.addAttribute("listaCategorias", categoriaService.listarCategorias());
		return "producto.jsp";
	}
	
	@RequestMapping("/login")
	public String login(Model model, @Valid @ModelAttribute Producto producto, BindingResult bindingResult, RedirectAttributes rm) {
		if(bindingResult.hasErrors()){
			List<String> errors = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
			rm.addFlashAttribute("errores", errors);
			return "redirect:/producto";
		}
		model.addAttribute("producto", producto);
		productoService.insertarProducto(producto);
		System.out.println(producto.getNombre() + " " + producto.getMarca() + " " + producto.getDescripcion() + " " + producto.getPrecio());
		return "redirect:/producto/listaProducto";
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id) {
		if(productoService.existeProducto(id)) {
			productoService.eliminarProducto(id);
		}
		return "redirect:/producto/listaProducto";
	}
	
	@RequestMapping("/listaProducto")
	public String listar(Model model) {
		model.addAttribute("listaProductos", productoService.listarProductos());
		return "listaProducto.jsp";
	}
	
	@RequestMapping("/findbuscar")
	public String find(Model model, @ModelAttribute("nombre") String nombre) {
		model.addAttribute("listaProductos", productoService.findBuscar(nombre));
		return "buscarProducto.jsp";
	}
	
	@RequestMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Producto producto = productoService.obtenerProducto(id);
		
		if(producto!=null) {
			model.addAttribute("producto", producto);
			model.addAttribute("listaCategorias", categoriaService.listarCategorias());
			return "edicionProducto.jsp";
		}
		return "redirect:/producto/listaProducto";
	}
	
	@RequestMapping("/editarProducto")
	public String editarProducto(@Valid @ModelAttribute Producto producto, BindingResult bindingResult, RedirectAttributes rm) {
		List<String> errors = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
		if(bindingResult.hasErrors()) {
			rm.addFlashAttribute("errores", errors);
			return "redirect:/producto/editar/"+producto.getId();
		}
		productoService.editarProducto(producto);
		return "redirect:/producto/listaProducto";
	}
	
}
