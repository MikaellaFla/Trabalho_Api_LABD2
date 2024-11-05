package com.ApiServicos.ApiServicos.repository;

import com.ApiServicos.ApiServicos.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, String> {
}

