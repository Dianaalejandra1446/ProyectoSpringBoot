package com.campuslands.proyectoSpringBoot.Configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.proyectoSpringBoot.Dto.SedesDTO;
import com.campuslands.proyectoSpringBoot.repositories.entities.SedesEntity;

@Component
public class SedeConverte {
    @Autowired
    private ModelMapper dbm;

    public SedesDTO sedesDTO (SedesEntity sedes){
        return dbm.map(sedes, SedesDTO.class);
    }
}
