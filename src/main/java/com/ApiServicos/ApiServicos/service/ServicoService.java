package com.ApiServicos.ApiServicos.service;

import com.ApiServicos.ApiServicos.Servico;

import java.util.List;

public interface ServicoService {
    public String createServico(Servico servico);
    public String updateServico(String id, Servico servico);
    public String deleteServico(String IdServico);
    public Servico getServico(String IdServico);
    public List<Servico> getAllServicos();
}
