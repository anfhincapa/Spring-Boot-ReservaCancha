package com.andresportsco.cancha.service;

import com.andresportsco.cancha.entity.Usuario;

public interface UsuarioService {
	
	public Iterable<Usuario> getAllUsuario();

	public Usuario crearUsuario(Usuario usuario) throws Exception;

}
