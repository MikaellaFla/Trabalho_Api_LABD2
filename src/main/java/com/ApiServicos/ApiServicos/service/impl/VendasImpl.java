package com.ApiServicos.ApiServicos.service.impl;

import com.ApiServicos.ApiServicos.Vendas;
import com.ApiServicos.ApiServicos.repository.VendasRepository;
import com.ApiServicos.ApiServicos.service.VendasService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendasImpl implements VendasService {

    private final VendasRepository vendasRepository;

    public VendasImpl(VendasRepository vendasRepository) {
        this.vendasRepository = vendasRepository;
    }

    @Override
    public String createVenda(Vendas venda) {
        vendasRepository.save(venda);
        return "Venda criada com sucesso";
    }

    @Override
    public String updateVenda(Vendas venda) {
        vendasRepository.save(venda);
        return "Venda atualizada com sucesso";
    }

    @Override
    public String deleteVenda(String IdVenda) {
        vendasRepository.deleteById(IdVenda);
        return "Venda deletada com sucesso";
    }

    @Override
    public Vendas getVenda(String IdVenda) {
        return vendasRepository.findById(IdVenda).orElse(null);
    }

    @Override
    public List<Vendas> getAllVendas() {
        return vendasRepository.findAll();
    }
}
