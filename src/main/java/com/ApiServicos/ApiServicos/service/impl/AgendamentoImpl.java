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
    public String updateAgendamento(int IdAgendamento, Agendamento agendamento) { // Alterado para int
        Optional<Agendamento> agendamentoExistente = agendamentoRepository.findById(IdAgendamento);
        if (agendamentoExistente.isPresent()) {
            Agendamento agendamentoAtualizado = agendamentoExistente.get();
            agendamentoAtualizado.setDataeHoraAgendamento(agendamento.getDataeHoraAgendamento());
            agendamentoAtualizado.setStatusAgendamento(agendamento.getStatusAgendamento());
            agendamentoAtualizado.setServico(agendamento.getServico());
            agendamentoAtualizado.setTipoAutomovel(agendamento.getTipoAutomovel()); // Nova variável
            agendamentoAtualizado.setNumeroPlaca(agendamento.getNumeroPlaca()); // Nova variável (como String)
            agendamentoRepository.save(agendamentoAtualizado);
            return "Sucesso";
        }
        return "Falha";
    }

    @Override
    public String deleteAgendamento(int IdAgendamento) { // Alterado para int
        agendamentoRepository.deleteById(IdAgendamento);
        return "Sucesso";
    }

    @Override
    public Agendamento getAgendamento(int IdAgendamento) { // Alterado para int
        return agendamentoRepository.findById(IdAgendamento).orElse(null);
    }

    @Override
    public List<Agendamento> getAllAgendamentos() {
        return agendamentoRepository.findAll();
    }
}



