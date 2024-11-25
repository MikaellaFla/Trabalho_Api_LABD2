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
    public ResponseEntity<Vendas> getVendaDetalhes(@PathVariable("IdVenda") int IdVenda) {  // Alterado para int
        Vendas venda = vendasService.getVenda(IdVenda);  // Alterado para int
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
    public ResponseEntity<String> updateVendaDetalhes(@PathVariable("IdVenda") int IdVenda, @RequestBody Vendas venda) {  // Alterado para int
        String resultado = vendasService.updateVenda(IdVenda, venda);  // Alterado para int
        if ("Sucesso".equals(resultado)) {
            return new ResponseEntity<>("Venda Atualizada Com Sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Venda Não Encontrada!", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{IdVenda}")
    public ResponseEntity<String> deleteVendaDetalhes(@PathVariable("IdVenda") int IdVenda) {  // Alterado para int
        vendasService.deleteVenda(IdVenda);  // Alterado para int
        return new ResponseEntity<>("Venda Deletada Com Sucesso!", HttpStatus.OK);
    }
}



