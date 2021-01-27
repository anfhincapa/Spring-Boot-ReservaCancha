package com.andresportsco.cancha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
