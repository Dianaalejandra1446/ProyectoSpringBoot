package com.campuslands.proyectoSpringBoot.Dto;

import lombok.Data;

@Data
public class EnvioAlimentosDTO {
    private Long idEnvioAlimentos;
    private String nombreProducto;
    private Double numToneladas;
}
