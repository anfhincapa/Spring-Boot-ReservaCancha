package com.andresportsco.cancha.service;

import java.util.Optional;

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
	
	private boolean validarUsuarioExistente(Usuario usuario) throws Exception {
		Optional<Usuario> usuarioEncontrado= repository.findByUsuario(usuario.getUsuario());
		if(usuarioEncontrado.isPresent()) {
			throw new Exception("Usuario no disponible");
		}
		
		return true;
	}
	
	private boolean passwordMatch(Usuario usuario) throws Exception {
		if(!usuario.getPassword().equals(usuario.getConfirmpassword())) {
			throw new Exception("Las contraseñas no coinciden");
		}
		
		return true;
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) throws Exception {
		if(validarUsuarioExistente(usuario) && passwordMatch(usuario)) {
			usuario=repository.save(usuario);
		}
		return usuario;
	}

}
