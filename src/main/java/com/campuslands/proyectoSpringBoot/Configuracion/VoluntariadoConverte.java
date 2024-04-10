package com.campuslands.proyectoSpringBoot.Configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.proyectoSpringBoot.Dto.DatosPersonalesDTO;
import com.campuslands.proyectoSpringBoot.Dto.VoluntariadosDTO;
import com.campuslands.proyectoSpringBoot.repositories.entities.VoluntariadosEntity;

@Component
public class VoluntariadoConverte {
    @Autowired
    private ModelMapper dbm;
    
    public VoluntariadosEntity voluntariadosEntityconvertDTO (VoluntariadosDTO voluntariadosDTO){
        return dbm.map(voluntariadosDTO, VoluntariadosEntity.class);
    }
    
    public VoluntariadosDTO voluntariadosDTO (VoluntariadosEntity voluntariadosEntity){
        VoluntariadosDTO voluntariadosDTO = dbm.map(voluntariadosEntity, VoluntariadosDTO.class);
        voluntariadosDTO.setIdVoluntariados(voluntariadosEntity.getId_voluntariado());
        voluntariadosDTO.setTipo(voluntariadosEntity.getTipo());
        voluntariadosDTO.setProfesion(voluntariadosEntity.getProfesion());
        voluntariadosDTO.setDisponiblidad(voluntariadosEntity.getDisponibilidad());

        DatosPersonalesDTO datosPersonalesDTO = new DatosPersonalesDTO();
        datosPersonalesDTO.setNombre(voluntariadosEntity.getDatosPersonales().getNombre());
        datosPersonalesDTO.setApellido(voluntariadosEntity.getDatosPersonales().getApellido());
        datosPersonalesDTO.setDocumento(voluntariadosEntity.getDatosPersonales().getDocumento());
        datosPersonalesDTO.setTelefono(voluntariadosEntity.getDatosPersonales().getTelefono());
        datosPersonalesDTO.setEmail(voluntariadosEntity.getDatosPersonales().getEmail());

        voluntariadosDTO.setDatosPersonales(datosPersonalesDTO);

        voluntariadosDTO.setSedeInscrita(voluntariadosEntity.getId_sede().getNombre_sede());
        return voluntariadosDTO;
    }
}
