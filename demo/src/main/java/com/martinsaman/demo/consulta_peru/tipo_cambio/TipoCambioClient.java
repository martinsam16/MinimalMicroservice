package com.martinsaman.demo.consulta_peru.tipo_cambio;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TipoCambioClient {

    private WebClient webClient;

    public TipoCambioClient(WebClient.Builder webClientBuilder) {
//        this.webClient = webClientBuilder.baseUrl("http://127.0.0.1:5000").build();
        this.webClient = webClientBuilder.baseUrl("http://172.22.33.148:5000").build();
//        this.webClient = webClientBuilder.baseUrl("http://consulta-peru-demo.herokuapp.com").build();
    }

    Mono<TipoCambioDto> getCurrentChange() {
        return this.webClient.get().uri("/cambio")
                .retrieve()
                .bodyToMono(TipoCambioDto.class);
    }

    Flux<TipoCambioDto> getChangePeriod(Integer year, Integer month) {
        return this.webClient.get().uri("/cambio/periodo/{year}/{month}", year, month)
                .retrieve()
                .bodyToFlux(TipoCambioDto.class);
    }
}
