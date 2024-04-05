package com.campuslands.proyectoSpringBoot.Services.Impl;

import java.util.ArrayList;
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

@AllArgsConstructor
@Service
public class CuotaServiceImpl implements CuotaService{
    @Autowired
    private CuotaRepository cuotaRepository;

    @Autowired
    private CuotaConverte convert;

    @Override
    @Transactional(readOnly = true)
    public List<CuotaDTO> findAll() {
       List<CuotaEntity> cuotaEntities = (List<CuotaEntity>) cuotaRepository.findAll();

       List<CuotaDTO> cuotaDTO = new ArrayList<>();
        
       for (CuotaEntity cuota : cuotaEntities) {
            cuotaDTO.add(convert.converCuotaDTO(cuota));
       }
       return cuotaDTO;
    }

    @Override
    public List<CuotaDTO> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public CuotaDTO save(CuotaDTO cuota) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public CuotaDTO update(Long id, CuotaDTO cuota) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }


/* 
    @Override
    public CuotaDTO save(CuotaDTO cuota) {
        return cuotaRepository.save(cuota);
    }

    @Override
    public void delete(Long id) {
        Optional<CuotaDTO> cuotaOptional=cuotaRepository.findById(id);
        if (cuotaOptional.isPresent()) {
            cuotaRepository.delete(cuotaOptional.get());
        }
    }

    @Override
    public CuotaDTO update(Long id, CuotaDTO cuota) {
        Optional<CuotaEntity> cuotaCurrentOptional=cuotaRepository.findById(id);

        if (cuotaCurrentOptional.isPresent()) {
            CuotaEntity cuotaCurrent=cuotaCurrentOptional.get();
            cuotaCurrent.setTipo(cuota.getTipo());
            cuotaCurrent.setValor(cuota.getValor());
            return cuotaCurrent;
        }
        return null;
    }
 */
}
