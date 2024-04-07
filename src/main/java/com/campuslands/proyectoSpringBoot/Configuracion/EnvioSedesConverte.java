package com.campuslands.proyectoSpringBoot.Configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.proyectoSpringBoot.Dto.EnvioSedesDTO;
import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioSedesEntity;

@Component
public class EnvioSedesConverte {
    @Autowired
    private ModelMapper dbm;

    public EnvioSedesEntity converterSedesEntity (EnvioSedesDTO envioSedesDTO){
        return dbm.map(envioSedesDTO, EnvioSedesEntity.class);
    }

    public EnvioSedesDTO envioSedesDTO(EnvioSedesEntity envioSedesEntity){
        EnvioSedesDTO envioSedesDTO = dbm.map(envioSedesEntity, EnvioSedesDTO.class);
        envioSedesDTO.setIdEnvioSedes(envioSedesEntity.getIdEnvioSedes());
        envioSedesDTO.setIdEnvio(envioSedesEntity.getIdEnvio().getIdEnvio());
        envioSedesDTO.setIdSede(envioSedesEntity.getIdSede().getId());

        return envioSedesDTO;
    }
}
