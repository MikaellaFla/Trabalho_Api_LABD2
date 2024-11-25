package com.ApiServicos.ApiServicos.service.impl;

import com.ApiServicos.ApiServicos.Servico;
import com.ApiServicos.ApiServicos.repository.ServicoRepository;
import com.ApiServicos.ApiServicos.service.ServicoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public String updateServico(String id, Servico servico) {
        // Buscando o serviço pelo ID
        Optional<Servico> existingServico = servicoRepository.findById(id);

        // Verifica se o serviço existe
        if (existingServico.isPresent()) {
            Servico servicoToUpdate = existingServico.get();
            // Atualiza os campos do serviço
            servicoToUpdate.setNomeServico(servico.getNomeServico());
            servicoToUpdate.setPrecoServico(servico.getPrecoServico());
            // Salva o serviço atualizado
            servicoRepository.save(servicoToUpdate);
            return "Sucesso";
        } else {
            // Retorna uma mensagem de erro caso o serviço não seja encontrado
            return "Serviço não encontrado!";
        }
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
