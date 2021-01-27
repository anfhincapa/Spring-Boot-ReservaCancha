package com.andresportsco.cancha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andresportsco.cancha.entity.Usuario;
import com.andresportsco.cancha.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioRepository repository;

	@Override
	public Iterable<Usuario> getAllUsuario() {
		
		return repository.findAll();
	}
	
	

}
