package com.campuslands.proyectoSpringBoot.Dto;

import lombok.Data;

@Data
public class EnvioMedicamentoDTO {
    private Long idEnvioMedicamentos;
    private String nombre_medicamento;
    private Integer numUnidades;
}
