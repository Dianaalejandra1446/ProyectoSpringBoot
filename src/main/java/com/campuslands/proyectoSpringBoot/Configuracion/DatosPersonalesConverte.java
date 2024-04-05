package com.campuslands.proyectoSpringBoot.Configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.proyectoSpringBoot.Dto.DatosPersonalesDTO;
import com.campuslands.proyectoSpringBoot.repositories.entities.DatosPersonalesEntity;

@Component
public class DatosPersonalesConverte {
    @Autowired
    private ModelMapper dbm;

    public DatosPersonalesEntity converDatosPersonalesEntity(DatosPersonalesDTO datosPersonales) {
        DatosPersonalesEntity datosPersonalesEntity = dbm.map(datosPersonales, DatosPersonalesEntity.class);
        return datosPersonalesEntity;
    }
    
}
