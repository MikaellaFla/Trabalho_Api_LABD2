package com.ApiServicos.ApiServicos.service;

import com.ApiServicos.ApiServicos.Agendamento;

import java.util.List;

public interface AgendamentoService {
    String createAgendamento(Agendamento agendamento);
    String updateAgendamento(String IdAgendamento, Agendamento agendamento);
    String deleteAgendamento(String IdAgendamento);
    Agendamento getAgendamento(String IdAgendamento);
    List<Agendamento> getAllAgendamentos();
}

