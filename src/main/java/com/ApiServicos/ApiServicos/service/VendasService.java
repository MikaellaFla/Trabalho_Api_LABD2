package com.ApiServicos.ApiServicos.service;

import com.ApiServicos.ApiServicos.Vendas;

import java.util.List;

public interface VendasService {
    public String createVenda(Vendas venda);
    public String updateVenda(Vendas venda);
    public String deleteVenda(String IdVenda);
    public Vendas getVenda(String IdVenda);
    public List<Vendas> getAllVendas();
}
