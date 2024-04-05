package com.campuslands.proyectoSpringBoot.Configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.proyectoSpringBoot.Dto.EnvioDTO;
import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioEntity;

@Component
public class EnvioConverte {
     @Autowired
     private ModelMapper dbm;

     public EnvioDTO envioDTO (EnvioEntity envio){
        return dbm.map(envio, EnvioDTO.class);
     }
}
