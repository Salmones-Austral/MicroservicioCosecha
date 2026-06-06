package cl.SalmonesAustral.Cosecha.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient sanitarioWebClient() {
        return WebClient.create("http://localhost:8093");
    }
}
