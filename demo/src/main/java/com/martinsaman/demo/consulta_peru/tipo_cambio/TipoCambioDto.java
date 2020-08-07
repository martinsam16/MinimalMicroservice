package com.martinsaman.demo.consulta_peru.tipo_cambio;

import lombok.Data;

@Data
public class TipoCambioDto {
    private Integer dia;
    private Float compra;
    private Float venta;
}
