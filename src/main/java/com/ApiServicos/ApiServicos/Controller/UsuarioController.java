package com.ApiServicos.ApiServicos.Controller;

import com.ApiServicos.ApiServicos.Usuario;
import com.ApiServicos.ApiServicos.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Usuario> getUsuarioDetalhes(@PathVariable("IdUsuario") String IdUsuario) {
        Usuario usuario = usuarioService.getUsuario(IdUsuario);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarioDetalhes() {
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createUsuarioDetalhes(@RequestBody Usuario usuario) {
        usuarioService.createUsuario(usuario);
        return new ResponseEntity<>("Usuário Criado Com Sucesso!", HttpStatus.CREATED);
    }

    @PutMapping("{IdUsuario}")
    public ResponseEntity<String> updateUsuarioDetalhes(@PathVariable("IdUsuario") String IdUsuario, @RequestBody Usuario usuario) {
        String resultado = usuarioService.updateUsuario(IdUsuario, usuario);
        if ("Sucesso".equals(resultado)) {
            return new ResponseEntity<>("Usuário Atualizado Com Sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuário Não Encontrado!", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{IdUsuario}")
    public ResponseEntity<String> deleteUsuarioDetalhes(@PathVariable("IdUsuario") String IdUsuario) {
        usuarioService.deleteUsuario(IdUsuario);
        return new ResponseEntity<>("Usuário Deletado Com Sucesso!", HttpStatus.OK);
    }
}

