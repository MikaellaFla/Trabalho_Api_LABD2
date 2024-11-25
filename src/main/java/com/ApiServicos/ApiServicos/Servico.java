package com.ApiServicos.ApiServicos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "servico_info")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática de IDs
    private int IdServico;

    private String NomeServico;
    private BigDecimal PrecoServico;

    @OneToMany(mappedBy = "servico", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("servico")
    private List<Agendamento> agendamentos;

    // Construtor vazio
    public Servico() {
    }

    // Construtor com parâmetros
    public Servico(String nomeServico, BigDecimal precoServico) {
        NomeServico = nomeServico;
        PrecoServico = precoServico;
    }

    // Getters e Setters
    public int getIdServico() {
        return IdServico;
    }

    public void setIdServico(int idServico) {
        this.IdServico = idServico;
    }

    public String getNomeServico() {
        return NomeServico;
    }

    public void setNomeServico(String nomeServico) {
        NomeServico = nomeServico;
    }

    public BigDecimal getPrecoServico() {
        return PrecoServico;
    }

    public void setPrecoServico(BigDecimal precoServico) {
        PrecoServico = precoServico;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }
}


