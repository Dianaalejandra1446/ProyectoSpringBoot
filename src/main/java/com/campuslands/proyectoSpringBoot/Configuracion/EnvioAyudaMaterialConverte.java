package com.campuslands.proyectoSpringBoot.Configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.proyectoSpringBoot.Dto.EnvioAyudaHumanitariaDTO;
import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioAyudaHumanitariaEntity;

@Component
public class EnvioAyudaMaterialConverte {
    @Autowired
    private ModelMapper dbm;

    public EnvioAyudaHumanitariaDTO envioAyudaHumanitariaDTO (EnvioAyudaHumanitariaEntity envioAyudaHumanitaria){
        return dbm.map(envioAyudaHumanitaria, EnvioAyudaHumanitariaDTO.class);
    }
}
