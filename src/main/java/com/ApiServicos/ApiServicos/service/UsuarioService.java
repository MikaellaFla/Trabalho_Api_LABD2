package com.ApiServicos.ApiServicos.service;

import com.ApiServicos.ApiServicos.Usuario;

import java.util.List;

public interface UsuarioService {
    String createUsuario(Usuario usuario);
    String updateUsuario(int IdUsuario, Usuario usuario); // Alterado para int
    String deleteUsuario(int IdUsuario); // Alterado para int
    Usuario getUsuario(int IdUsuario); // Alterado para int
    List<Usuario> getAllUsuarios();
}



