package com.martinsaman.demo.consulta_peru.tipo_cambio;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("change")
public interface TipoCambioClient {

    @GetMapping("/cambio")
    TipoCambioDto getCurrentChange();

    @GetMapping("/cambio/periodo/{anio}/{mes}")
    List<TipoCambioDto> getChangePeriod(@PathVariable("anio") Integer year, @PathVariable("mes") Integer month);
}
