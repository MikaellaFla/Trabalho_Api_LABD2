package com.ApiServicos.ApiServicos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "servico_info")
public class Servico
{
    @Id
    private String IdServico;
    private String NomeServico;
    private BigDecimal PrecoServico;

    @OneToMany(mappedBy = "servico", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("servico")
    private List<Agendamento> agendamentos;

    public Servico() {
    }

    public Servico(String nomeServico, BigDecimal precoServico, String idServico) {
        NomeServico = nomeServico;
        PrecoServico = precoServico;
        IdServico = idServico;
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

    public String getIdServico() {
        return IdServico;
    }

    public void setIdServico(String idServico) {
        IdServico = idServico;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
