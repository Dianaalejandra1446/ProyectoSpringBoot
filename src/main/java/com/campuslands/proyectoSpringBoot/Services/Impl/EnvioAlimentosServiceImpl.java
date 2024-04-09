package com.campuslands.proyectoSpringBoot.Services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campuslands.proyectoSpringBoot.Configuracion.EnvioAlimentosConverte;
import com.campuslands.proyectoSpringBoot.Dto.EnvioAlimentosDTO;
import com.campuslands.proyectoSpringBoot.Services.EnvioAlimentoService;
import com.campuslands.proyectoSpringBoot.repositories.EnvioAlimentosRepository;
import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioAlimentosEntity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EnvioAlimentosServiceImpl implements EnvioAlimentoService {
    @Autowired
    private EnvioAlimentosRepository envioAlimentosRepository;
    @Autowired
    private EnvioAlimentosConverte envioAlimentosConvert;

    @Override
    @Transactional(readOnly = true)
    public List<EnvioAlimentosDTO> findAll() {
        List<EnvioAlimentosEntity> envioAlimento = (List<EnvioAlimentosEntity>) envioAlimentosRepository.findAll();
        return envioAlimento.stream()
                            .map(envioAlimentos -> envioAlimentosConvert.converEnvioAlimentosDTO(envioAlimentos))
                            .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public EnvioAlimentosDTO findById(Long id) {
        Optional<EnvioAlimentosEntity> envioOptional = envioAlimentosRepository.findById(id);
        if (envioOptional.isPresent()) {
            EnvioAlimentosEntity envioAlimentosEntity = envioOptional.get();
            return envioAlimentosConvert.converEnvioAlimentosDTO(envioAlimentosEntity);
        }
        return null;
    }

    @Override
    @Transactional
    public EnvioAlimentosDTO save(EnvioAlimentosDTO envioAlimentos) {
        EnvioAlimentosEntity envio = envioAlimentosConvert.convertirDTOAlimentosEntity(envioAlimentos);
        envioAlimentosRepository.save(envio);
        return envioAlimentosConvert.converEnvioAlimentosDTO(envio);
    }

    @Override
    public void delete(Long id) {
        envioAlimentosRepository.deleteById(id);
    }

    @Override
    public EnvioAlimentosDTO update(Long id, EnvioAlimentosDTO envioAlimentos) {
        Optional<EnvioAlimentosEntity> envioCurreOptional = envioAlimentosRepository.findById(id);
        if (envioCurreOptional.isPresent()) {
            EnvioAlimentosEntity envioCurrent = envioAlimentosConvert.convertirDTOAlimentosEntity(envioAlimentos);
            envioCurrent.setIdEnvioAlimentos(id);
            envioCurrent.setNombreProducto(envioAlimentos.getNombreProducto());
            envioCurrent.setNumToneladas(envioAlimentos.getNumToneladas());

            envioAlimentosRepository.save(envioCurrent);

            return envioAlimentosConvert.converEnvioAlimentosDTO(envioCurrent);
        }
        return null;
    }
    
}
