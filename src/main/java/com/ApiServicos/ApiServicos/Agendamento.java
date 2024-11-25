package com.ApiServicos.ApiServicos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "agendamento_info")
public class Agendamento {

    @Id
    private int IdAgendamento;

    private LocalDateTime DataeHoraAgendamento;
    private String StatusAgendamento;
    private String tipoAutomovel;
    private String numeroPlaca;

    @ManyToOne
    @JoinColumn(name = "id_servico", nullable = false)
    private Servico servico;

    @OneToMany(mappedBy = "agendamento", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("agendamento")
    private List<Vendas> vendas;

    // Construtor vazio
    public Agendamento() {
    }

    // Construtor completo
    public Agendamento(int idAgendamento, Servico servico, String statusAgendamento, LocalDateTime dataeHoraAgendamento, String tipoAutomovel, String numeroPlaca) {
        this.IdAgendamento = idAgendamento;
        this.servico = servico;
        this.StatusAgendamento = statusAgendamento;
        this.DataeHoraAgendamento = dataeHoraAgendamento;
        this.tipoAutomovel = tipoAutomovel;
        this.numeroPlaca = numeroPlaca;
    }

    // Getters e Setters
    public int getIdAgendamento() {
        return IdAgendamento;
    }

    public void setIdAgendamento(int idAgendamento) {
        this.IdAgendamento = idAgendamento;
    }

    public LocalDateTime getDataeHoraAgendamento() {
        return DataeHoraAgendamento;
    }

    public void setDataeHoraAgendamento(LocalDateTime dataeHoraAgendamento) {
        this.DataeHoraAgendamento = dataeHoraAgendamento;
    }

    public String getStatusAgendamento() {
        return StatusAgendamento;
    }

    public void setStatusAgendamento(String statusAgendamento) {
        this.StatusAgendamento = statusAgendamento;
    }

    public String getTipoAutomovel() {
        return tipoAutomovel;
    }

    public void setTipoAutomovel(String tipoAutomovel) {
        this.tipoAutomovel = tipoAutomovel;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public List<Vendas> getVendas() {
        return vendas;
    }

    public void setVendas(List<Vendas> vendas) {
        this.vendas = vendas;
    }
}



