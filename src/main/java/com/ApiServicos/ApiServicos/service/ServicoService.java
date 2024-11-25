package com.ApiServicos.ApiServicos.service;

import com.ApiServicos.ApiServicos.Servico;

import java.util.List;

public interface ServicoService {
    public String createServico(Servico servico);
    public String updateServico(int id, Servico servico); // Alterado para int
    public String deleteServico(int IdServico); // Alterado para int
    public Servico getServico(int IdServico); // Alterado para int
    public List<Servico> getAllServicos();
}

