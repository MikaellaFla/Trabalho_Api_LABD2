package com.ApiServicos.ApiServicos.service.impl;

import com.ApiServicos.ApiServicos.Usuario;
import com.ApiServicos.ApiServicos.repository.UsuarioRepository;
import com.ApiServicos.ApiServicos.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class UsuarioImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public String createUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
        return "Usuário criado com sucesso!";
    }

    @Override
    public String updateUsuario(int IdUsuario, Usuario usuario) { // Alterado para int
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(IdUsuario); // Alterado para int
        if (usuarioExistente.isPresent()) {
            Usuario usuarioAtualizado = usuarioExistente.get();
            usuarioAtualizado.setLoginUsuario(usuario.getLoginUsuario());
            usuarioAtualizado.setSenhaUsuario(usuario.getSenhaUsuario());
            usuarioAtualizado.setTipoUsuario(usuario.getTipoUsuario());
            usuarioRepository.save(usuarioAtualizado);
            return "Sucesso";
        }
        return "Falha";
    }

    @Override
    public String deleteUsuario(int IdUsuario) { // Alterado para int
        usuarioRepository.deleteById(IdUsuario); // Alterado para int
        return "Usuário deletado com sucesso!";
    }

    @Override
    public Usuario getUsuario(int IdUsuario) { // Alterado para int
        return usuarioRepository.findById(IdUsuario).orElse(null); // Alterado para int
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }
}



