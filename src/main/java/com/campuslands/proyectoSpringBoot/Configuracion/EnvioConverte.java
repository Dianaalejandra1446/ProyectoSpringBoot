package com.campuslands.proyectoSpringBoot.Configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.proyectoSpringBoot.Dto.EnvioDTO;
import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioEntity;

@Component
public class EnvioConverte {
     @Autowired
     private ModelMapper dbm;

   public EnvioEntity converteDTOEnvioEntity (EnvioDTO envioDTO){
      return dbm.map(envioDTO, EnvioEntity.class);
   }  

   public EnvioDTO converterEnvioDTO (EnvioEntity envio){
        EnvioDTO envioDTO = dbm.map(envio, EnvioDTO.class);
        envioDTO.setIdEnvio(envio.getIdEnvio());
        envioDTO.setCodigoEnvio(envio.getCodigoEnvio());
        envioDTO.setNombreRefugio(envio.getNombreRefugio());
        envioDTO.setDestino(envio.getDestino());
        envioDTO.setFechaSalida(envio.getFechaSalida());

        return envioDTO;
     }
}
