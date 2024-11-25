package com.ApiServicos.ApiServicos.Controller;

import com.ApiServicos.ApiServicos.Agendamento;
import com.ApiServicos.ApiServicos.service.AgendamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @GetMapping("{IdAgendamento}")
    public ResponseEntity<Agendamento> getAgendamentoDetalhes(@PathVariable("IdAgendamento") String IdAgendamento) {
        Agendamento agendamento = agendamentoService.getAgendamento(IdAgendamento);
        if (agendamento != null) {
            return new ResponseEntity<>(agendamento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Caso o agendamento não seja encontrado
        }
    }

    @GetMapping()
    public ResponseEntity<List<Agendamento>> getAllAgendamentoDetalhes() {
        List<Agendamento> agendamentos = agendamentoService.getAllAgendamentos();
        return new ResponseEntity<>(agendamentos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createAgendamentoDetalhes(@RequestBody Agendamento agendamento) {
        agendamentoService.createAgendamento(agendamento);
        return new ResponseEntity<>("Agendamento Criado Com Sucesso!", HttpStatus.CREATED);
    }

    @PutMapping("{IdAgendamento}")
    public ResponseEntity<String> updateAgendamentoDetalhes(@PathVariable("IdAgendamento") String IdAgendamento, @RequestBody Agendamento agendamento) {
        String resultado = agendamentoService.updateAgendamento(IdAgendamento, agendamento);
        if ("Sucesso".equals(resultado)) {
            return new ResponseEntity<>("Agendamento Atualizado Com Sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Agendamento Não Encontrado!", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{IdAgendamento}")
    public ResponseEntity<String> deleteAgendamentoDetalhes(@PathVariable("IdAgendamento") String IdAgendamento) {
        agendamentoService.deleteAgendamento(IdAgendamento);
        return new ResponseEntity<>("Agendamento Deletado Com Sucesso!", HttpStatus.OK);
    }
}

