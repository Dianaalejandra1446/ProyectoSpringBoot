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

    public EnvioAlimentosEntity convertirDTOAlimentosEntity(EnvioAlimentosDTO envioAlimentosDTO){
        return dbm.map(envioAlimentosDTO, EnvioAlimentosEntity.class);
    }

    public EnvioAlimentosDTO converEnvioAlimentosDTO(EnvioAlimentosEntity envioAlimentos){
        EnvioAlimentosDTO envioAlimentosDTO = dbm.map(envioAlimentos, EnvioAlimentosDTO.class);
        envioAlimentosDTO.setIdEnvioAlimentos(envioAlimentos.getIdEnvioAlimentos());
        envioAlimentosDTO.setNombreProducto(envioAlimentos.getNombreProducto());
        envioAlimentosDTO.setNumToneladas(envioAlimentos.getNumToneladas());

        return envioAlimentosDTO;
    }
}
