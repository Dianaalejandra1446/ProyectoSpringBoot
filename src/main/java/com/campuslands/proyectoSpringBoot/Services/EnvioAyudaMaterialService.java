package com.campuslands.proyectoSpringBoot.Services;

import java.util.List;

import com.campuslands.proyectoSpringBoot.Dto.EnvioAyudaMaterialDTO;

public interface EnvioAyudaMaterialService {
    List<EnvioAyudaMaterialDTO> findAll();
    EnvioAyudaMaterialDTO findById(Long id);
    EnvioAyudaMaterialDTO save(EnvioAyudaMaterialDTO envioAyudaMaterial);
    void delete(Long id);
    EnvioAyudaMaterialDTO update(Long id,EnvioAyudaMaterialDTO envioAyudaMaterial);
}
