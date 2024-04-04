package com.campuslands.proyectoSpringBoot.Dto;

import lombok.Data;

@Data
public class EnvioMedicamentoDTO {
    private Long idEnvioMedicamentos;
    private String nombreMedicamento;
    private Integer numUnidades;
}
