package com.ApiServicos.ApiServicos.Controller;

import com.ApiServicos.ApiServicos.Usuario;
import com.ApiServicos.ApiServicos.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("{IdUsuario}")
    public Usuario getUsuarioDetalhes(@PathVariable("IdUsuario") String IdUsuario) {
        return usuarioService.getUsuario(IdUsuario);
    }

    @GetMapping
    public List<Usuario> getAllUsuarioDetalhes() {
        return usuarioService.getAllUsuarios();
    }

    @PostMapping
    public String createUsuarioDetalhes(@RequestBody Usuario usuario) {
        usuarioService.createUsuario(usuario);
        return "Usuário Criado Com Sucesso!";
    }

    @PutMapping
    public String updateUsuarioDetalhes(@RequestBody Usuario usuario) {
        usuarioService.updateUsuario(usuario);
        return "Usuário Atualizado Com Sucesso!";
    }

    @DeleteMapping("{IdUsuario}")
    public String deleteUsuarioDetalhes(@PathVariable("IdUsuario") String IdUsuario) {
        usuarioService.deleteUsuario(IdUsuario);
        return "Usuário Deletado Com Sucesso!";
    }
}
