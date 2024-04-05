package com.campuslands.proyectoSpringBoot.Configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.campuslands.proyectoSpringBoot.Dto.VoluntariadosDTO;
import com.campuslands.proyectoSpringBoot.repositories.entities.VoluntariadosEntity;

@Component
public class VoluntariadoConverte {
    private ModelMapper dbm;

    public VoluntariadosDTO voluntariadosDTO (VoluntariadosEntity voluntariadosEntity){
        return dbm.map(voluntariadosEntity, VoluntariadosDTO.class);
    }
}
