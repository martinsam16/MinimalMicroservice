package com.martinsaman.demo.consulta_peru.tipo_cambio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@CrossOrigin
@RequestMapping("/cambio")
public class TipoCambioRest {

    @Autowired
    TipoCambioClient tipoCambioClient;

    @GetMapping
    Mono<TipoCambioDto> getCurrentChange() {
        return tipoCambioClient.getCurrentChange();
    }

    @GetMapping("/periodo/{anio}/{mes}")
    Flux<TipoCambioDto> getChangePeriod(@PathVariable("anio") Integer year, @PathVariable("mes") Integer month) {
        return tipoCambioClient.getChangePeriod(year, month);
    }
}
