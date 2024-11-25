package com.ApiServicos.ApiServicos.service;

import com.ApiServicos.ApiServicos.Vendas;

import java.util.List;

public interface VendasService {
    String createVenda(Vendas venda);
    String updateVenda(int idVenda, Vendas venda); // Alterado para aceitar o ID como int
    String deleteVenda(int idVenda); // Alterado para aceitar o ID como int
    Vendas getVenda(int idVenda); // Alterado para aceitar o ID como int
    List<Vendas> getAllVendas();
}


