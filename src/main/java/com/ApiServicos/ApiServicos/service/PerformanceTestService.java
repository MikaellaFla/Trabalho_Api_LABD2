package com.ApiServicos.ApiServicos.service;

import com.ApiServicos.ApiServicos.Servico;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class PerformanceTestService {

    private final ServicoService servicoService;

    public PerformanceTestService(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    // FIFO - Processa requisições sequencialmente
    public void runFIFO(int numRequests) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numRequests; i++) {
            try {
                // Cria uma instância de Servico
                Servico servico = new Servico("Serviço " + i, BigDecimal.valueOf(50.0));

                // Chama o método createServico
                servicoService.createServico(servico);
            } catch (Exception e) {
                System.out.println("Erro na requisição " + (i + 1) + ": " + e.getMessage());
            }
        }

        long endTime = System.currentTimeMillis();

        // Calcula o tempo em segundos
        double totalTimeInSeconds = (endTime - startTime) / 1000.0;
        System.out.printf("FIFO - %d requisições concluídas em %.2f segundos.%n", numRequests, totalTimeInSeconds);
    }

    public void runRoundRobin(int numRequests) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numRequests; i++) {
            try {
                // Cria uma instância de Servico
                Servico servico = new Servico("Serviço " + i, BigDecimal.valueOf(50.0));

                // Chama o método createServico
                servicoService.createServico(servico);
            } catch (Exception e) {
                System.out.println("Erro na requisição " + (i + 1) + ": " + e.getMessage());
            }
        }

        long endTime = System.currentTimeMillis();

        // Calcula o tempo em segundos
        double totalTimeInSeconds = (endTime - startTime) / 1000.0;
        System.out.printf("Round Robin (sem threads) - %d requisições concluídas em %.2f segundos.%n", numRequests, totalTimeInSeconds);
    }
}