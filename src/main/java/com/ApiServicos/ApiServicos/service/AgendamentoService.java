package com.ApiServicos.ApiServicos.service;

import com.ApiServicos.ApiServicos.Agendamento;
import com.ApiServicos.ApiServicos.Servico;

import java.util.List;

public interface AgendamentoService {
    public String createAgendamento(Agendamento agendamento);
    public String updateAgendamento(Agendamento agendamento);
    public String deleteAgendamento(String IdAgendamento);
    public Agendamento getAgendamento(String IdAgendamento);
    public List<Agendamento> getAllAgendamentos();
}
