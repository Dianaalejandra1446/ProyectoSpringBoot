package com.campuslands.proyectoSpringBoot.Services;

import com.campuslands.proyectoSpringBoot.Dto.EnvioMedicamentoDTO;

public interface EnvioMedicamentosService {

    EnvioMedicamentoDTO findById(Long id);

    EnvioMedicamentoDTO save(EnvioMedicamentoDTO envioMedicamento);
    
    void delete(Long id);

    EnvioMedicamentoDTO update(Long id,EnvioMedicamentoDTO envioMedicamento);
    
}
