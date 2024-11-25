package com.ApiServicos.ApiServicos.Controller;

import com.ApiServicos.ApiServicos.Vendas;
import com.ApiServicos.ApiServicos.service.VendasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Vendas> getVendaDetalhes(@PathVariable("IdVenda") String IdVenda) {
        Vendas venda = vendasService.getVenda(IdVenda);
        if (venda != null) {
            return new ResponseEntity<>(venda, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Vendas>> getAllVendasDetalhes() {
        List<Vendas> vendas = vendasService.getAllVendas();
        return new ResponseEntity<>(vendas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createVendaDetalhes(@RequestBody Vendas venda) {
        vendasService.createVenda(venda);
        return new ResponseEntity<>("Venda Criada Com Sucesso!", HttpStatus.CREATED);
    }

    @PutMapping("{IdVenda}")
    public ResponseEntity<String> updateVendaDetalhes(@PathVariable("IdVenda") String IdVenda, @RequestBody Vendas venda) {
        String resultado = vendasService.updateVenda(IdVenda, venda);
        if ("Sucesso".equals(resultado)) {
            return new ResponseEntity<>("Venda Atualizada Com Sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Venda Não Encontrada!", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{IdVenda}")
    public ResponseEntity<String> deleteVendaDetalhes(@PathVariable("IdVenda") String IdVenda) {
        vendasService.deleteVenda(IdVenda);
        return new ResponseEntity<>("Venda Deletada Com Sucesso!", HttpStatus.OK);
    }
}


