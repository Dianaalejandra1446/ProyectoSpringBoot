package com.campuslands.proyectoSpringBoot.Configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.proyectoSpringBoot.Dto.SociosDTO;
import com.campuslands.proyectoSpringBoot.repositories.entities.SociosEntity;

@Component
public class SociosConverte {
    @Autowired
    private ModelMapper dbm;

    public SociosDTO sociosDTO (SociosEntity sociosEntity){
        SociosDTO sociosDTO=dbm.map(sociosEntity,SociosDTO.class);
        return sociosDTO; 
    }
}
