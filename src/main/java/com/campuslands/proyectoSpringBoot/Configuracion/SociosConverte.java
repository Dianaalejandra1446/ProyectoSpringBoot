package com.campuslands.proyectoSpringBoot.Configuracion;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.proyectoSpringBoot.Dto.CuotaDTO;
import com.campuslands.proyectoSpringBoot.Dto.DatosPersonalesDTO;
import com.campuslands.proyectoSpringBoot.Dto.SociosDTO;
import com.campuslands.proyectoSpringBoot.repositories.entities.CuotaEntity;
import com.campuslands.proyectoSpringBoot.repositories.entities.DatosPersonalesEntity;
import com.campuslands.proyectoSpringBoot.repositories.entities.SociosEntity;

@Component
public class SociosConverte {
    @Autowired
    private ModelMapper dbm;

    public SociosEntity converteSociosEntity (SociosDTO sociosDTO){
        return dbm.map(sociosDTO,SociosEntity.class);
    }

    public SociosDTO sociosDTO (SociosEntity sociosEntity){
        SociosDTO sociosDTO=dbm.map(sociosEntity,SociosDTO.class);
        sociosDTO.setIdSocio(sociosEntity.getId());

        if (sociosEntity.getId_DatosPersonales()!= null) {
            List<DatosPersonalesDTO> datosPersonales = new ArrayList<>();
            for (DatosPersonalesEntity datosPersonalesEntity : sociosEntity.getId_DatosPersonales()) {
                DatosPersonalesDTO datosPersonalesDTO = dbm.map(datosPersonalesEntity, DatosPersonalesDTO.class);
                datosPersonales.add(datosPersonalesDTO);
            }
            sociosDTO.setDatosPersonales(datosPersonales);
        }
        sociosDTO.setCuentaBancaria(sociosEntity.getCuentaBancaria());
        sociosDTO.setFechaPago(sociosEntity.getFechaPago());
        if (sociosEntity.getId_cuota() != null) {
            List<CuotaDTO> datosCuota = new ArrayList<>();
            for (CuotaEntity cuotaEntity : sociosEntity.getId_cuota()) {
                CuotaDTO cuotaDTO = dbm.map(cuotaEntity, CuotaDTO.class);
                datosCuota.add(cuotaDTO);
            } 
        }
        return sociosDTO; 
    }
}
