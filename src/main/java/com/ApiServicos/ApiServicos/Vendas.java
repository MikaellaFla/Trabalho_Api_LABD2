package com.ApiServicos.ApiServicos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendas_info")
public class Vendas {

    @Id
    private String IdVenda;

    @ManyToOne
    @JoinColumn(name = "id_agendamento", nullable = false) // Chave estrangeira que se refere ao IdAgendamento
    @JsonIgnoreProperties("vendas")
    private Agendamento agendamento;

    public Vendas() {
    }

    public Vendas(String idVenda, Agendamento agendamento) {
        IdVenda = idVenda;
        this.agendamento = agendamento;
    }

    public String getIdVenda() {
        return IdVenda;
    }

    public void setIdVenda(String idVenda) {
        IdVenda = idVenda;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }
}

