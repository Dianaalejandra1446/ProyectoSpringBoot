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

    public EnvioMedicamentoDTO envioMedicamentoDTO (EnvioMedicamentosEntity envioMedicamentos){
        return dbm.map(envioMedicamentos, EnvioMedicamentoDTO.class);
    }
}
