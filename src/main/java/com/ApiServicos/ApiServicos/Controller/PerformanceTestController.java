package com.ApiServicos.ApiServicos.Controller;

import com.ApiServicos.ApiServicos.service.PerformanceTestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PerformanceTestController {

    private final PerformanceTestService performanceTestService;

    public PerformanceTestController(PerformanceTestService performanceTestService) {
        this.performanceTestService = performanceTestService;
    }

    // Endpoint para o FIFO
    @GetMapping("/test/fifo")
    public String testFIFO(@RequestParam int numRequests) {
        performanceTestService.runFIFO(numRequests);
        return "Teste FIFO concluído!";
    }

    // Endpoint para o Round Robin
    @GetMapping("/test/rr")
    public String testRoundRobin(@RequestParam int numRequests, @RequestParam int numThreads) {
        performanceTestService.runRoundRobin(numRequests, numThreads);
        return "Teste Round Robin concluído!";
    }
}
