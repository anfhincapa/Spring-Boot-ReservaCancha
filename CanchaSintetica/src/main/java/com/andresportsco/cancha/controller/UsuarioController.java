package com.andresportsco.cancha.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.andresportsco.cancha.entity.Usuario;
import com.andresportsco.cancha.repository.RoleRepository;
import com.andresportsco.cancha.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	RoleRepository roleRepository;
	
	@GetMapping("/")
	public  String index() {
		return "index";
	}
	
	@GetMapping("/userform")
	public String userform(Model model) {
		model.addAttribute("userForm", new Usuario());
		model.addAttribute("userList", usuarioService.getAllUsuario());
		model.addAttribute("roles", roleRepository.findAll());
		model.addAttribute("listTab","active");
		return "user-form/user-view";
	}
	
	@PostMapping("/userform")
	public String crearUsuario(@Valid @ModelAttribute("userForm")Usuario usuario, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("userForm", usuario);
			model.addAttribute("formTab", "active");
		}else {
			try {
				usuarioService.crearUsuario(usuario);
				model.addAttribute("userForm", new Usuario());
				model.addAttribute("listTab", "active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("userForm", usuario);
				model.addAttribute("formTab", "active");
				model.addAttribute("userList", usuarioService.getAllUsuario());
				model.addAttribute("roles", roleRepository.findAll());
			}
		}
		
		model.addAttribute("userList", usuarioService.getAllUsuario());
		model.addAttribute("roles", roleRepository.findAll());
		return "user-form/user-view";
	}

}
