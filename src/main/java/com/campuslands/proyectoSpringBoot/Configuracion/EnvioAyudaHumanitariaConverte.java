package com.campuslands.proyectoSpringBoot.Configuracion;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.proyectoSpringBoot.Dto.EnvioAyudaHumanitariaDTO;
import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioAyudaHumanitariaEntity;
import com.campuslands.proyectoSpringBoot.repositories.entities.VoluntariadosEntity;


@Component
public class EnvioAyudaHumanitariaConverte {
    @Autowired
    private ModelMapper dbm;

    public EnvioAyudaHumanitariaEntity converterDTOAyudaHumanitariaEntity(EnvioAyudaHumanitariaDTO envioAyudaHumanitariaDTO){
        return dbm.map(envioAyudaHumanitariaDTO, EnvioAyudaHumanitariaEntity.class);
    }

    public EnvioAyudaHumanitariaDTO converterEnvioAyudaHumanitariaDTO(EnvioAyudaHumanitariaEntity envioAyudaHumanitaria) {
        EnvioAyudaHumanitariaDTO envioAyudaHumanitariaDTO = dbm.map(envioAyudaHumanitaria, EnvioAyudaHumanitariaDTO.class);

        envioAyudaHumanitariaDTO.setIdAyudaHumanitaria(envioAyudaHumanitaria.getIdAyudaHumanitaria());

        envioAyudaHumanitariaDTO.setNumVoluntarios(envioAyudaHumanitaria.getNumVoluntarios());

        if (envioAyudaHumanitaria.getIdVoluntariados() != null) {
            List<String> profesiones = new ArrayList<>();
            for (VoluntariadosEntity voluntariado : envioAyudaHumanitaria.getIdVoluntariados()) {
                // Añadimos cada profesion a la lista dto
                profesiones.add(voluntariado.getProfesion());
            } 
        
        envioAyudaHumanitariaDTO.setProfesionVoluntarios(profesiones);
        }
        return envioAyudaHumanitariaDTO;
    }
}
