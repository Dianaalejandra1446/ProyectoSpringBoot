package com.campuslands.proyectoSpringBoot.Dto;

import java.util.Date;

import lombok.Data;

@Data
public class CuotaDTO {
    private Long idEnvio;
    private Double codigoEnvio;
    private String nombreRefugio;
    private String destino;
    private Date fechaSalida;
}
