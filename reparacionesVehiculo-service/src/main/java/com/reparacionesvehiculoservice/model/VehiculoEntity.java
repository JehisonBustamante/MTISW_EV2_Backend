package com.reparacionesvehiculoservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoEntity {
    private Integer id;
    private String patente;
    private String marca;
    private String modelo;
    private String tipo;
    private String motor;
    private Integer anio;
    private Integer asientos;
    private Integer kilometraje;
}