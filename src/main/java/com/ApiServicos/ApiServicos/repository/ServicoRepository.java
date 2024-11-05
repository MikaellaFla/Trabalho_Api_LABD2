package com.ApiServicos.ApiServicos.repository;

import com.ApiServicos.ApiServicos.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico, String> {
}
