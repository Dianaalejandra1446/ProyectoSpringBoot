package com.campuslands.proyectoSpringBoot.Configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.proyectoSpringBoot.Dto.CuotaDTO;
import com.campuslands.proyectoSpringBoot.repositories.entities.CuotaEntity;

@Component
public class CuotaDTOConvertir {
    @Autowired
    private ModelMapper dbm;

    public CuotaDTO converCuotaDTO(CuotaEntity cuota){
        return null;
        //Terminar
    }
}