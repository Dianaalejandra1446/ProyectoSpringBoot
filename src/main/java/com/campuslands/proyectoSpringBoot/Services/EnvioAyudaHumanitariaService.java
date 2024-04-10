package com.campuslands.proyectoSpringBoot.Services;

import com.campuslands.proyectoSpringBoot.Dto.EnvioAyudaHumanitariaDTO;

public interface EnvioAyudaHumanitariaService {
    EnvioAyudaHumanitariaDTO findById(Long id);
    EnvioAyudaHumanitariaDTO save(EnvioAyudaHumanitariaDTO envioAyudaHumanitaria);
    void delete(Long id);
    EnvioAyudaHumanitariaDTO update(Long id,EnvioAyudaHumanitariaDTO envioAyudaHumanitaria);
    
}
