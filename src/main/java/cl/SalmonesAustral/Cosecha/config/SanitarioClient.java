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
        try{
            return this.webClient.get()
            .uri("http://localhost:8092/sanitario/jaula/" + jaulaId + "/puede cosechar")
            .retrieve()
            .bodyToMono(Boolean.class)
            .block();
        }catch(Exception e){
            return false;
        }
       
    }
}