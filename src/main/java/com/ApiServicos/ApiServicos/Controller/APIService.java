package com.ApiServicos.ApiServicos.Controller;

import com.ApiServicos.ApiServicos.Servico;
import com.ApiServicos.ApiServicos.service.ServicoService;
import jakarta.persistence.Id;
import jdk.jfr.Registered;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/servico")
public class APIService
{
    ServicoService servicoService;

    public APIService(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @GetMapping("{IdServico}")
    public Servico getServicoDetalhes(@PathVariable("IdServico") String IdServico)
    {
        return servicoService.getServico(IdServico);
    }

    @GetMapping()
    public List<Servico> getAllServicoDetalhes()
    {
        return servicoService.getAllServicos();
    }

    @PostMapping
    public String createServicoDetalhes(@RequestBody Servico servico)
    {
        servicoService.createServico(servico);
        return "Servico Criado Com Sucesso!";
    }

    @PutMapping
    public String updateServicoDetalhes(@RequestBody Servico servico)
    {
        servicoService.updateServico(servico);
        return "Servico Atualizado Com Sucesso!";
    }

    @DeleteMapping("{IdServico}")
    public String deleteServicoDetalhes(@PathVariable("IdServico") String IdServico)
    {
        servicoService.deleteServico(IdServico);
        return "Servico Deletado Com Sucesso!";
    }
}
