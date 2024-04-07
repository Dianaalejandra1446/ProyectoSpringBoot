package com.campuslands.proyectoSpringBoot.Configuracion;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.campuslands.proyectoSpringBoot.Dto.DatosPersonalesDTO;
import com.campuslands.proyectoSpringBoot.Dto.VoluntariadosDTO;
import com.campuslands.proyectoSpringBoot.repositories.entities.DatosPersonalesEntity;
import com.campuslands.proyectoSpringBoot.repositories.entities.VoluntariadosEntity;

@Component
public class VoluntariadoConverte {
    private ModelMapper dbm;

    public VoluntariadosDTO voluntariadosDTO (VoluntariadosEntity voluntariadosEntity){
        VoluntariadosDTO voluntariadosDTO = dbm.map(voluntariadosEntity, VoluntariadosDTO.class);
        voluntariadosDTO.setIdVoluntariados(voluntariadosEntity.getId());
        voluntariadosDTO.setTipo(voluntariadosEntity.getTipo());
        voluntariadosDTO.setProfesion(voluntariadosEntity.getProfesion());
        voluntariadosDTO.setDisponiblidad(voluntariadosEntity.getDisponiblidad());
        voluntariadosDTO.setNumeroTrabajosParticipados(voluntariadosEntity.getNumeroTrabajosParticipados());
        if (voluntariadosEntity.getIdDatosPersonales() != null) {
            List<DatosPersonalesDTO> datosPersonales = new ArrayList<>();
            for (DatosPersonalesEntity datosPersonalesEntity : voluntariadosEntity.getIdDatosPersonales()) {
                DatosPersonalesDTO datosPersonalesDTO = dbm.map(datosPersonalesEntity, DatosPersonalesDTO.class);
                datosPersonales.add(datosPersonalesDTO);
            }
            voluntariadosDTO.setDatosPersonales(datosPersonales);
        }
        voluntariadosDTO.setSedeInscrita(voluntariadosEntity.getIdsede().getNombre_sede());
        return voluntariadosDTO;
    }
}
