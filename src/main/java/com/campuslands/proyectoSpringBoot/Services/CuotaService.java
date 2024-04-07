package com.campuslands.proyectoSpringBoot.Services;

import java.util.List;

import com.campuslands.proyectoSpringBoot.Dto.CuotaDTO;

public interface CuotaService {
    List<CuotaDTO> findAll();

    CuotaDTO findById(Long id);

    CuotaDTO save(CuotaDTO cuota);

    void delete(Long id);

    CuotaDTO update(Long id,CuotaDTO cuota);
}
