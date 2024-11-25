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
    private int idVenda; // Alterado para int

    @ManyToOne
    @JoinColumn(name = "id_agendamento", nullable = false) // Chave estrangeira que se refere ao IdAgendamento
    @JsonIgnoreProperties("vendas")
    private Agendamento agendamento;

    public Vendas() {
    }

    public Vendas(int idVenda, Agendamento agendamento) {
        this.idVenda = idVenda;
        this.agendamento = agendamento;
    }

    public int getIdVenda() { // Alterado para int
        return idVenda;
    }

    public void setIdVenda(int idVenda) { // Alterado para int
        this.idVenda = idVenda;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }
}


