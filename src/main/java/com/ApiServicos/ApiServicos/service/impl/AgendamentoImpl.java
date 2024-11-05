package com.ApiServicos.ApiServicos.service.impl;

import com.ApiServicos.ApiServicos.Agendamento;
import com.ApiServicos.ApiServicos.Servico;
import com.ApiServicos.ApiServicos.repository.AgendamentoRepository;
import com.ApiServicos.ApiServicos.repository.ServicoRepository;
import com.ApiServicos.ApiServicos.service.AgendamentoService;
import com.ApiServicos.ApiServicos.service.ServicoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoImpl implements AgendamentoService {

    AgendamentoRepository agendamentoRepository;
    ServicoRepository servicoRepository;

    public AgendamentoImpl(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    @Override
    public String createAgendamento(Agendamento agendamento) {
        agendamentoRepository.save(agendamento);
        return "Sucesso";
    }

    @Override
    public String updateAgendamento(Agendamento agendamento) {
        agendamentoRepository.save(agendamento);
        return "Sucesso";
    }

    @Override
    public String deleteAgendamento(String IdAgendamento) {
        agendamentoRepository.deleteById(IdAgendamento);
        return "Sucesso";
    }

    @Override
    public Agendamento getAgendamento(String IdAgendamento) {
        return agendamentoRepository.findById(IdAgendamento).get();
    }

    @Override
    public List<Agendamento> getAllAgendamentos() {
        return agendamentoRepository.findAll();
    }
}
