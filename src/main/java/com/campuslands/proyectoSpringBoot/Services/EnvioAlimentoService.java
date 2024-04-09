package com.campuslands.proyectoSpringBoot.Services;

import java.util.List;

import com.campuslands.proyectoSpringBoot.Dto.EnvioAlimentosDTO;

public interface EnvioAlimentoService {
    List<EnvioAlimentosDTO> findAll();
    EnvioAlimentosDTO findById(Long id);
    EnvioAlimentosDTO save(EnvioAlimentosDTO envioAlimentos);
    void delete(Long id);
    EnvioAlimentosDTO update(Long id,EnvioAlimentosDTO envioAlimentos);
}
