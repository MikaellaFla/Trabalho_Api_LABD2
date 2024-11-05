package com.ApiServicos.ApiServicos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "agendamento_info")
public class Agendamento {

    @Id
    private String IdAgendamento;
    private LocalDateTime DataeHoraAgendamento;
    private String StatusAgendamento;

    @ManyToOne
    @JoinColumn(name = "id_servico", nullable = false) // nome da coluna no banco de dados
    private Servico servico;

    @OneToMany(mappedBy = "agendamento", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("agendamento")
    private List<Vendas> vendas;

    public Agendamento() {
    }

    public Agendamento(String idAgendamento, Servico servico, String statusAgendamento, LocalDateTime dataeHoraAgendamento) {
        IdAgendamento = idAgendamento;
        this.servico = servico;
        StatusAgendamento = statusAgendamento;
        DataeHoraAgendamento = dataeHoraAgendamento;
    }

    public String getIdAgendamento() {
        return IdAgendamento;
    }

    public void setIdAgendamento(String idAgendamento) {
        IdAgendamento = idAgendamento;
    }

    public LocalDateTime getDataeHoraAgendamento() {
        return DataeHoraAgendamento;
    }

    public void setDataeHoraAgendamento(LocalDateTime dataeHoraAgendamento) {
        DataeHoraAgendamento = dataeHoraAgendamento;
    }

    public String getStatusAgendamento() {
        return StatusAgendamento;
    }

    public void setStatusAgendamento(String statusAgendamento) {
        StatusAgendamento = statusAgendamento;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;

    }
}
