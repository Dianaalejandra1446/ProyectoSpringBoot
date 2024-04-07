package com.campuslands.proyectoSpringBoot.Configuracion;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.proyectoSpringBoot.Dto.EnvioAlimentosDTO;
import com.campuslands.proyectoSpringBoot.Dto.EnvioAyudaMaterialDTO;
import com.campuslands.proyectoSpringBoot.Dto.EnvioMedicamentoDTO;
import com.campuslands.proyectoSpringBoot.Dto.EnvioSedesDTO;
import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioAlimentosEntity;
import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioAyudaMaterialEntity;
import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioMedicamentosEntity;
import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioSedesEntity;

@Component
public class EnvioAyudaMaterialConverte {
    @Autowired
    private ModelMapper dbm;

    public EnvioAyudaMaterialEntity convertirDTOAEntity(EnvioAyudaMaterialDTO envioAyudaMaterialDTO) {
        return dbm.map(envioAyudaMaterialDTO, EnvioAyudaMaterialEntity.class);
    }

    public EnvioAyudaMaterialDTO convertirEntityADTO(EnvioAyudaMaterialEntity envioAyudaMaterialEntity) {
        EnvioAyudaMaterialDTO envioAyudaMaterialDTO = dbm.map(envioAyudaMaterialEntity, EnvioAyudaMaterialDTO.class);
        envioAyudaMaterialDTO.setIdAyudaMaterial(envioAyudaMaterialEntity.getId_ayuda_material());

        if (envioAyudaMaterialEntity.getIdEnvioAlimentos() != null) {
            List<EnvioAlimentosDTO> datosAlimentos = new ArrayList<>();
            for (EnvioAlimentosEntity envioAlimentosEntity : envioAyudaMaterialEntity.getIdEnvioAlimentos()) {
                EnvioAlimentosDTO envioAlimentosDTO = dbm.map(envioAlimentosEntity, EnvioAlimentosDTO.class);
                datosAlimentos.add(envioAlimentosDTO);
            }
            envioAyudaMaterialDTO.setEnvioAlimentos(datosAlimentos);
        }

        if (envioAyudaMaterialEntity.getIdEnvioMedicamentos() != null) {
            List<EnvioMedicamentoDTO> datosMedicamentos = new ArrayList<>();
            for (EnvioMedicamentosEntity envioMedicamento : envioAyudaMaterialEntity.getIdEnvioMedicamentos()) {
                EnvioMedicamentoDTO envioMedicamentoDTO = dbm.map(envioMedicamento, EnvioMedicamentoDTO.class);
                datosMedicamentos.add(envioMedicamentoDTO);
            }
            envioAyudaMaterialDTO.setEnvioMedicamentos(datosMedicamentos);
        }

        if (envioAyudaMaterialEntity.getIdEnvioSedes() != null) {
            List<EnvioSedesDTO> EnvioSedesDatos = new ArrayList<>();
            for (EnvioSedesEntity envioSede : envioAyudaMaterialEntity.getIdEnvioSedes()) {
                EnvioSedesDTO envioSedesDTO = dbm.map(envioSede, EnvioSedesDTO.class);
                EnvioSedesDatos.add(envioSedesDTO);
            }
            envioAyudaMaterialDTO.setEnvioSedes(EnvioSedesDatos);
        }
        return envioAyudaMaterialDTO;
    }
}

    