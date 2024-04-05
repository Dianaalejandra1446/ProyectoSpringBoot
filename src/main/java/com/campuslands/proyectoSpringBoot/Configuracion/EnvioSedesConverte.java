package com.campuslands.proyectoSpringBoot.Configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.proyectoSpringBoot.Dto.EnvioSedesDTO;
import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioSedesEntity;

@Component
public class EnvioSedesConverte {
    @Autowired
    private ModelMapper dbm;

    public EnvioSedesDTO envioSedesDTO(EnvioSedesEntity envioSedesEntity){
        return dbm.map(envioSedesEntity, EnvioSedesDTO.class);
    }
}
