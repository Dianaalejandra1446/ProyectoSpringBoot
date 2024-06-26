package com.campuslands.proyectoSpringBoot.Configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.proyectoSpringBoot.Dto.EnvioMedicamentoDTO;
import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioMedicamentosEntity;

@Component
public class EnvioMedicamentoConverte {
    @Autowired
    private ModelMapper dbm;

    public EnvioMedicamentosEntity converteEnvioMedicamentosEntity (EnvioMedicamentoDTO envioEnvioMedicamento){
        return dbm.map(envioEnvioMedicamento, EnvioMedicamentosEntity.class);
    }

    public EnvioMedicamentoDTO converteEnvioMedicamentoDTO (EnvioMedicamentosEntity envioMedicamentos){
        EnvioMedicamentoDTO envioMedicamentoDTO = dbm.map(envioMedicamentos, EnvioMedicamentoDTO.class);

        envioMedicamentoDTO.setIdEnvioMedicamentos(envioMedicamentos.getIdEnvioMedicamentos());
        envioMedicamentoDTO.setNombreMedicamento(envioMedicamentos.getNombre_medicamento());
        envioMedicamentoDTO.setNumUnidades(envioMedicamentos.getNumUnidades());

        return envioMedicamentoDTO;
    }
}
