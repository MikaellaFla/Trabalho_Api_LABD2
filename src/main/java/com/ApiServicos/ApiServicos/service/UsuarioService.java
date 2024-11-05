package com.ApiServicos.ApiServicos.service;

import com.ApiServicos.ApiServicos.Usuario;

import java.util.List;

public interface UsuarioService {
    public String createUsuario(Usuario usuario);
    public String updateUsuario(Usuario usuario);
    public String deleteUsuario(String IdUsuario);
    public Usuario getUsuario(String IdUsuario);
    public List<Usuario> getAllUsuarios();
}

