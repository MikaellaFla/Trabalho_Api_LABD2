package com.ApiServicos.ApiServicos.repository;

import com.ApiServicos.ApiServicos.Agendamento;
import com.ApiServicos.ApiServicos.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendasRepository extends JpaRepository<Vendas, String> {
}
