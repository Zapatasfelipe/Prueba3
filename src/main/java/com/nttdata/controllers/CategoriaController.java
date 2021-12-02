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

import com.nttdata.models.Categoria;
import com.nttdata.services.CategoriaService;



@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping("")
	public String categoria() {
		return "categoria.jsp";
	}
	
	
	@RequestMapping("/createCategoria")
	public String login(Model model, @Valid @ModelAttribute Categoria categoria, BindingResult bindingResult, RedirectAttributes rm) {
		if(bindingResult.hasErrors()){
			List<String> errors = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
			rm.addFlashAttribute("errores", errors);
			return "redirect:/categoria";
		}
		model.addAttribute("categoria", categoria);
		categoriaService.insertarCategoria(categoria);
		System.out.println(categoria.getNombre());
		return "redirect:/categoria/listaCategoria";
	}
	
	@RequestMapping("/listaCategoria")
	public String listar(Model model) {
		model.addAttribute("listaCategorias", categoriaService.listarCategorias());
		return "listaCategoria.jsp";
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id) {
		if(categoriaService.existeCategoria(id)) {
			categoriaService.eliminarCategoria(id);
		}
		return "redirect:/categoria/listaCategoria";
	}
	
}
