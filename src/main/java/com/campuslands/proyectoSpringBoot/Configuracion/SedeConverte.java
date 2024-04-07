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

    public SedesEntity converteSedesEntity(SedesDTO sedesDTO){
        return dbm.map(sedesDTO, SedesEntity.class);
    }

    public SedesDTO converteSedesDTO (SedesEntity sedes){
        SedesDTO sedesDTO = dbm.map(sedes, SedesDTO.class);
        sedesDTO.setId(sedes.getId());
        sedesDTO.setNombre_sede(sedes.getNombre_sede());
        sedesDTO.setCiudad(sedes.getCiudad());
        sedesDTO.setDomicilio(sedes.getDomicilio());
        sedesDTO.setNombre_director(sedes.getNombre_director());

        return sedesDTO;
    }
}
