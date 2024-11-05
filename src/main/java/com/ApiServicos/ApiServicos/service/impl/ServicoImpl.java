package com.ApiServicos.ApiServicos.service.impl;

import com.ApiServicos.ApiServicos.Servico;
import com.ApiServicos.ApiServicos.repository.ServicoRepository;
import com.ApiServicos.ApiServicos.service.ServicoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoImpl implements ServicoService {

    ServicoRepository servicoRepository;

    public ServicoImpl(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    @Override
    public String createServico(Servico servico) {
        servicoRepository.save(servico);
        return "Sucesso";
    }

    @Override
    public String updateServico(Servico servico) {
        servicoRepository.save(servico);
        return "Sucesso";
    }

    @Override
    public String deleteServico(String IdServico) {
        servicoRepository.deleteById(IdServico);
        return "Sucesso";
    }

    @Override
    public Servico getServico(String IdServico) {
        return servicoRepository.findById(IdServico).get();
    }

    @Override
    public List<Servico> getAllServicos() {
        return servicoRepository.findAll();
    }
}
