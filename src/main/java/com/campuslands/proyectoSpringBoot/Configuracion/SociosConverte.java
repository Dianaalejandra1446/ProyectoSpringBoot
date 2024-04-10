package com.campuslands.proyectoSpringBoot.Configuracion;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.proyectoSpringBoot.Dto.DatosPersonalesDTO;
import com.campuslands.proyectoSpringBoot.Dto.SociosDTO;
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

        DatosPersonalesDTO datosPersonalesDTO = new DatosPersonalesDTO();
        datosPersonalesDTO.setNombre(sociosEntity.getIdDatosPersonales().getNombre());
        datosPersonalesDTO.setApellido(sociosEntity.getIdDatosPersonales().getApellido());
        datosPersonalesDTO.setDocumento(sociosEntity.getIdDatosPersonales().getDocumento());
        datosPersonalesDTO.setTelefono(sociosEntity.getIdDatosPersonales().getTelefono());
        datosPersonalesDTO.setEmail(sociosEntity.getIdDatosPersonales().getEmail());

        sociosDTO.setDatosPersonales(datosPersonalesDTO);

        sociosDTO.setCuentaBancaria(sociosEntity.getCuentaBancaria());
        sociosDTO.setFechaPago(sociosEntity.getFechaPago());

        sociosDTO.setTipoCuota(sociosEntity.getId_cuota().getTipo());

        return sociosDTO; 
    }

/*     public List<SociosDTO> sociosDTOList(List<SociosEntity> sociosEntityList) {
        return sociosEntityList.stream().map(this::sociosDTO).collect(Collectors.toList());
    } */
}
