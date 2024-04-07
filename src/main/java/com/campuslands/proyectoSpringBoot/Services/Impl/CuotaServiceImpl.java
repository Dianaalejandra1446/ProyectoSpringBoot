package com.campuslands.proyectoSpringBoot.Services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campuslands.proyectoSpringBoot.Configuracion.CuotaConverte;
import com.campuslands.proyectoSpringBoot.Dto.CuotaDTO;
import com.campuslands.proyectoSpringBoot.Services.CuotaService;
import com.campuslands.proyectoSpringBoot.repositories.CuotaRepository;
import com.campuslands.proyectoSpringBoot.repositories.entities.CuotaEntity;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CuotaServiceImpl implements CuotaService{
    @Autowired
    private CuotaRepository cuotaRepository;

    @Autowired
    private CuotaConverte cuotaConvert;

    @Override
    @Transactional(readOnly = true)
    public List<CuotaDTO> findAll() {
        List<CuotaEntity> cuotas = (List<CuotaEntity>) cuotaRepository.findAll();
        return cuotas.stream()
                     .map(cuota -> cuotaConvert.converCuotaDTO(cuota))
                     .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CuotaDTO findById(Long id) {
        Optional<CuotaEntity> cuotaOptional = cuotaRepository.findById(id);
        if (cuotaOptional.isPresent()) {
            CuotaEntity cuotaEntity = cuotaOptional.get();
            return cuotaConvert.converCuotaDTO(cuotaEntity);
        }
        return null; // O puedes lanzar una excepción de recurso no encontrado aquí
    }
    
    @Override
    @Transactional
    public CuotaDTO save(CuotaDTO cuotaDTO) {
        CuotaEntity cuota = cuotaConvert.convertirDTOCuotaEntity(cuotaDTO);
        cuotaRepository.save(cuota);
        // Conversion a DTO
        return cuotaConvert.converCuotaDTO(cuota);
    }

    @Override
    public void delete(Long id) {
        cuotaRepository.deleteById(id);
    }

    @Override
    public CuotaDTO update(Long id, CuotaDTO cuota) {
        // Buscar el libro por el id
        Optional<CuotaEntity> cuotaCurrentOptional = cuotaRepository.findById(id);
        if (cuotaCurrentOptional.isPresent()) {
            
            CuotaEntity cuotaCurrent = cuotaConvert.convertirDTOCuotaEntity(cuota);
            cuotaCurrent.setIdCuota(id);
            cuotaCurrent.setTipo(cuota.getTipo());
            cuotaCurrent.setValor(cuota.getValor());

            cuotaRepository.save(cuotaCurrent);

            return cuotaConvert.converCuotaDTO(cuotaCurrent);
        }
        return null;
    }
    
}
