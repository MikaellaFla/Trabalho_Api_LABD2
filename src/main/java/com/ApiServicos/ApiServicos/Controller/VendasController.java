package com.ApiServicos.ApiServicos.Controller;

import com.ApiServicos.ApiServicos.Vendas;
import com.ApiServicos.ApiServicos.service.VendasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendasController {

    private final VendasService vendasService;

    public VendasController(VendasService vendasService) {
        this.vendasService = vendasService;
    }

    @GetMapping("{IdVenda}")
    public Vendas getVendaDetalhes(@PathVariable("IdVenda") String IdVenda) {
        return vendasService.getVenda(IdVenda);
    }

    @GetMapping()
    public List<Vendas> getAllVendasDetalhes() {
        return vendasService.getAllVendas();
    }

    @PostMapping
    public String createVendaDetalhes(@RequestBody Vendas venda) {
        vendasService.createVenda(venda);
        return "Venda Criada Com Sucesso!";
    }

    @PutMapping
    public String updateVendaDetalhes(@RequestBody Vendas venda) {
        vendasService.updateVenda(venda);
        return "Venda Atualizada Com Sucesso!";
    }

    @DeleteMapping("{IdVenda}")
    public String deleteVendaDetalhes(@PathVariable("IdVenda") String IdVenda) {
        vendasService.deleteVenda(IdVenda);
        return "Venda Deletada Com Sucesso!";
    }
}

