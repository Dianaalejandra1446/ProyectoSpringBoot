package com.campuslands.proyectoSpringBoot.Dto;

import java.util.List;

import lombok.Data;

@Data
public class EnvioAyudaMaterialDTO {
    private Long idAyudaMaterial;
    private List<EnvioAlimentosDTO> envioAlimentos;
    private List<EnvioMedicamentoDTO> envioMedicamentos;
    private List<EnvioSedesDTO> envioSedes;
}
