package com.campuslands.proyectoSpringBoot.Services;

import com.campuslands.proyectoSpringBoot.Dto.EnvioSedesDTO;

public interface EnvioSedeService {

    EnvioSedesDTO findById(Long id);

    EnvioSedesDTO save(EnvioSedesDTO envioSedes);

    void delete(Long id);

    EnvioSedesDTO update(Long id,EnvioSedesDTO envioSedes);
}
