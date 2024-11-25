package com.ApiServicos.ApiServicos.Controller;

import com.ApiServicos.ApiServicos.Servico;
import com.ApiServicos.ApiServicos.service.ServicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servico")
public class APIService {

    private final ServicoService servicoService;

    public APIService(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @GetMapping("{IdServico}")
    public ResponseEntity<Servico> getServicoDetalhes(@PathVariable("IdServico") String IdServico) {
        Servico servico = servicoService.getServico(IdServico);
        if (servico != null) {
            return new ResponseEntity<>(servico, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Caso o serviço não seja encontrado
        }
    }

    @GetMapping
    public ResponseEntity<List<Servico>> getAllServicoDetalhes() {
        List<Servico> servicos = servicoService.getAllServicos();
        return new ResponseEntity<>(servicos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createServicoDetalhes(@RequestBody Servico servico) {
        servicoService.createServico(servico);
        return new ResponseEntity<>("Servico Criado Com Sucesso!", HttpStatus.CREATED);
    }

    @PutMapping("{IdServico}")
    public ResponseEntity<String> updateServicoDetalhes(@PathVariable("IdServico") String IdServico, @RequestBody Servico servico) {
        String resultado = servicoService.updateServico(IdServico, servico);
        if ("Sucesso".equals(resultado)) {
            return new ResponseEntity<>("Servico Atualizado Com Sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Servico Não Encontrado!", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{IdServico}")
    public ResponseEntity<String> deleteServicoDetalhes(@PathVariable("IdServico") String IdServico) {
        servicoService.deleteServico(IdServico);
        return new ResponseEntity<>("Servico Deletado Com Sucesso!", HttpStatus.OK);
    }
}

