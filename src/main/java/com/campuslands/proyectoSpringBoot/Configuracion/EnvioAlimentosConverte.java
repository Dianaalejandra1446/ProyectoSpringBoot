package com.campuslands.proyectoSpringBoot.Configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.proyectoSpringBoot.Dto.EnvioAlimentosDTO;
import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioAlimentosEntity;

@Component
public class EnvioAlimentosConverte {
    @Autowired
    private ModelMapper dbm;

    public EnvioAlimentosDTO converEnvioAlimentosDTO(EnvioAlimentosEntity envioAlimentos){
        return dbm.map(envioAlimentos, EnvioAlimentosDTO.class);
    }
}
