package com.campuslands.proyectoSpringBoot.Services;

import java.util.List;

import com.campuslands.proyectoSpringBoot.Dto.DatosPersonalesDTO;

public interface DatosPersonalesService {
    List<DatosPersonalesDTO> findAll();

    DatosPersonalesDTO findById(Long id);

    DatosPersonalesDTO save(DatosPersonalesDTO datosPersonales);

    void delete(Long id);

    DatosPersonalesDTO update(Long id,DatosPersonalesDTO datosPersonales);
}
