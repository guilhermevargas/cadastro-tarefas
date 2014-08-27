package br.com.caelum.tarefas.controller;

import br.com.caelum.tarefas.model.Usuario;

public interface UsuarioDAO {
	public boolean existeUsuario(Usuario usuario);
}
