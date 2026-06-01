package cl.SalmonesAustral.Cosecha.config;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class SanitarioClient {

    private final WebClient webClient;

    public SanitarioClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public boolean puedeCosechar(int jaulaId) {
        return webClient.get()
                .uri("http://localhost:8083/sanitario/puede-cosechar/{id}", jaulaId)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }
}