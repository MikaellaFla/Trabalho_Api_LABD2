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

    // Round Robin - Processa requisições em threads
    public void runRoundRobin(int numRequests, int numThreads) {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numRequests; i++) {
            int requestId = i;
            executor.submit(() -> {
                try {
                    // Cria uma instância de Servico
                    Servico servico = new Servico("Serviço " + requestId, BigDecimal.valueOf(50.0));

                    // Chama o método createServico
                    servicoService.createServico(servico);
                } catch (Exception e) {
                    System.out.println("Erro na requisição " + (requestId + 1) + ": " + e.getMessage());
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        // Calcula o tempo em segundos
        double totalTimeInSeconds = (endTime - startTime) / 1000.0;
        System.out.printf("RR - %d requisições concluídas em %.2f segundos.%n", numRequests, totalTimeInSeconds);
    }
}