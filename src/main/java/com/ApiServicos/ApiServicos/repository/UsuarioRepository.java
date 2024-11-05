package com.ApiServicos.ApiServicos.repository;

import com.ApiServicos.ApiServicos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
