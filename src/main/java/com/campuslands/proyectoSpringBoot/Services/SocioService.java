package com.campuslands.proyectoSpringBoot.Services;

import java.util.List;

import com.campuslands.proyectoSpringBoot.Dto.CuotaDTO;
import com.campuslands.proyectoSpringBoot.Dto.SociosDTO;

public interface SocioService {

    List<SociosDTO> findAll();

    SociosDTO findById(Long id);

    SociosDTO save(SociosDTO cuota);

    void delete(Long id);

    SociosDTO update(Long id,SociosDTO cuota);  
/*     
    List<SociosDTO> findAllSocioByTipoCuota(CuotaDTO tipoCuota); */

}
