package com.campuslands.proyectoSpringBoot.Dto;

import java.util.List;

import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioAlimentosEntity;
import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioMedicamentosEntity;
import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioSedesEntity;

import lombok.Data;

@Data
public class EnvioAyudaMaterialDTO {
    private Long idAyudaMaterial;
    private List<EnvioAlimentosEntity> envioAlimentos;
    private List<EnvioMedicamentosEntity> envioMedicamentos;
    private List<EnvioSedesEntity> envioSedes;
}
