package com.ApiServicos.ApiServicos.service.impl;

import com.ApiServicos.ApiServicos.Usuario;
import com.ApiServicos.ApiServicos.repository.UsuarioRepository;
import com.ApiServicos.ApiServicos.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioImpl implements UsuarioService {

    UsuarioRepository usuarioRepository;

    public UsuarioImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public String createUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
        return "Usuário criado com sucesso!";
    }

    @Override
    public String updateUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
        return "Usuário atualizado com sucesso!";
    }

    @Override
    public String deleteUsuario(String IdUsuario) {
        usuarioRepository.deleteById(IdUsuario);
        return "Usuário deletado com sucesso!";
    }

    @Override
    public Usuario getUsuario(String IdUsuario) {
        return usuarioRepository.findById(IdUsuario).orElse(null);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }
}

