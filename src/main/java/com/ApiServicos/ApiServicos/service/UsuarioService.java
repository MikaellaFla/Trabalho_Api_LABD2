package com.ApiServicos.ApiServicos.service;

import com.ApiServicos.ApiServicos.Usuario;

import java.util.List;

public interface UsuarioService {
    String createUsuario(Usuario usuario);
    String updateUsuario(String IdUsuario, Usuario usuario); // Adicionado o ID como parâmetro
    String deleteUsuario(String IdUsuario);
    Usuario getUsuario(String IdUsuario);
    List<Usuario> getAllUsuarios();
}


