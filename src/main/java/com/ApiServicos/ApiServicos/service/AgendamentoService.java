package com.ApiServicos.ApiServicos.service;

import com.ApiServicos.ApiServicos.Agendamento;

import java.util.List;

public interface AgendamentoService {
    String createAgendamento(Agendamento agendamento);
    String updateAgendamento(int IdAgendamento, Agendamento agendamento); // Alterado para int
    String deleteAgendamento(int IdAgendamento); // Alterado para int
    Agendamento getAgendamento(int IdAgendamento); // Alterado para int
    List<Agendamento> getAllAgendamentos();
}


