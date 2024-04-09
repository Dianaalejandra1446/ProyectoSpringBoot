package com.campuslands.proyectoSpringBoot.Services;

import java.util.List;

import com.campuslands.proyectoSpringBoot.Dto.EnvioDTO;

public interface EnvioService {
    List<EnvioDTO> findAll();

    EnvioDTO findById(Long id);

    EnvioDTO save(EnvioDTO envioDTO);

    void delete(Long id);

    EnvioDTO update(Long id,EnvioDTO envioDTO);
}
