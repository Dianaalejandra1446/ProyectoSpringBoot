package com.campuslands.proyectoSpringBoot.Services;

import java.util.List;

import com.campuslands.proyectoSpringBoot.Dto.CuotaDTO;
import com.campuslands.proyectoSpringBoot.repositories.entities.CuotaEntity;

public interface CuotaService {
    List<CuotaDTO> findAll();

    List<CuotaDTO> findById(Long id);

    CuotaDTO save(CuotaDTO cuota);

    void delete(Long id);

    CuotaDTO update(Long id,CuotaDTO cuota);
}
