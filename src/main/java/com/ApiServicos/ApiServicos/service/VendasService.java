package com.ApiServicos.ApiServicos.service;

import com.ApiServicos.ApiServicos.Vendas;

import java.util.List;

public interface VendasService {
    String createVenda(Vendas venda);
    String updateVenda(String IdVenda, Vendas venda); // Alterado para aceitar o ID
    String deleteVenda(String IdVenda);
    Vendas getVenda(String IdVenda);
    List<Vendas> getAllVendas();
}

