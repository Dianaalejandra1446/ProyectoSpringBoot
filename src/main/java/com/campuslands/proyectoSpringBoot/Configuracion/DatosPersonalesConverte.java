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
    
    public DatosPersonalesDTO convertiPersonalesDTO(DatosPersonalesEntity datosPersonalesEntity){
        DatosPersonalesDTO datosPersonalesDTO = dbm.map(datosPersonalesEntity,DatosPersonalesDTO.class);
        datosPersonalesDTO.setIdDatos(datosPersonalesEntity.getIdDatos());
        datosPersonalesDTO.setNombre(datosPersonalesEntity.getNombre());
        datosPersonalesDTO.setApellido(datosPersonalesEntity.getApellido());
        datosPersonalesDTO.setDocumento(datosPersonalesEntity.getDocumento());
        datosPersonalesDTO.setEmail(datosPersonalesEntity.getEmail());
        datosPersonalesDTO.setTelefono(datosPersonalesEntity.getTelefono());

        return datosPersonalesDTO;
    }
}
