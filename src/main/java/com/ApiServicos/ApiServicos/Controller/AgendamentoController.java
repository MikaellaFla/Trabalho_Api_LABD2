package com.ApiServicos.ApiServicos.Controller;

import com.ApiServicos.ApiServicos.Agendamento;
import com.ApiServicos.ApiServicos.service.AgendamentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController
{
    AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @GetMapping("{IdAgendamento}")
    public Agendamento getAgendamentoDetalhes(@PathVariable("IdAgendamento") String IdAgendamento)
    {
        return agendamentoService.getAgendamento(IdAgendamento);
    }

    @GetMapping()
    public List<Agendamento> getAllAgendamentoDetalhes()
    {
        return agendamentoService.getAllAgendamentos();
    }

    @PostMapping
    public String createAgendamentoDetalhes(@RequestBody Agendamento agendamento)
    {
        agendamentoService.createAgendamento(agendamento);
        return "Servico Criado Com Sucesso!";
    }

    @PutMapping
    public String updateAgendamentoDetalhes(@RequestBody Agendamento agendamento)
    {
        agendamentoService.updateAgendamento(agendamento);
        return "Servico Atualizado Com Sucesso!";
    }

    @DeleteMapping("{IdAgendamento}")
    public String deleteAgendamentoDetalhes(@PathVariable("IdAgendamento") String IdAgendamento)
    {
        agendamentoService.deleteAgendamento(IdAgendamento);
        return "Servico Deletado Com Sucesso!";
    }
}
