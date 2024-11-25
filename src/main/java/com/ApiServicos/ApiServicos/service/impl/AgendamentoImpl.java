package com.ApiServicos.ApiServicos.service.impl;

import com.ApiServicos.ApiServicos.Agendamento;
import com.ApiServicos.ApiServicos.repository.AgendamentoRepository;
import com.ApiServicos.ApiServicos.service.AgendamentoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoImpl implements AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoImpl(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    @Override
    public String createAgendamento(Agendamento agendamento) {
        agendamentoRepository.save(agendamento);
        return "Sucesso";
    }

    @Override
    public String updateAgendamento(String IdAgendamento, Agendamento agendamento) {
        Optional<Agendamento> agendamentoExistente = agendamentoRepository.findById(IdAgendamento);
        if (agendamentoExistente.isPresent()) {
            Agendamento agendamentoAtualizado = agendamentoExistente.get();
            agendamentoAtualizado.setDataeHoraAgendamento(agendamento.getDataeHoraAgendamento());
            agendamentoAtualizado.setStatusAgendamento(agendamento.getStatusAgendamento());
            agendamentoAtualizado.setServico(agendamento.getServico());
            agendamentoRepository.save(agendamentoAtualizado);
            return "Sucesso";
        }
        return "Falha";
    }

    @Override
    public String deleteAgendamento(String IdAgendamento) {
        agendamentoRepository.deleteById(IdAgendamento);
        return "Sucesso";
    }

    @Override
    public Agendamento getAgendamento(String IdAgendamento) {
        return agendamentoRepository.findById(IdAgendamento).orElse(null);
    }

    @Override
    public List<Agendamento> getAllAgendamentos() {
        return agendamentoRepository.findAll();
    }
}

