package br.edu.ifrs.canoas.lds.demo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifrs.canoas.lds.demo.domain.Usuario;
import br.edu.ifrs.canoas.lds.demo.service.UsuarioService;

@Controller
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping("/")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("usuarios", usuarioService.findAll());
		return mav; 
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable Long id) {
		usuarioService.delete(id);
		return new ModelAndView("redirect:/"); 
	}
	
	@GetMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mav = new ModelAndView("form");
		mav.addObject("usuario", new Usuario());
		return mav;  
	}
	
	@GetMapping("/edita/{id}")
	public ModelAndView edita(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("form");
		mav.addObject("usuario", usuarioService.busca(id));
		return mav;  
	}
	
	@PostMapping("/salva")
	public ModelAndView salva(@Valid Usuario usuario) {
		ModelAndView mav = new ModelAndView("redirect:/");
		usuarioService.salva(usuario);
		return mav;  
	}

}
