package com.campuslands.proyectoSpringBoot.Services.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campuslands.proyectoSpringBoot.Configuracion.EnvioSedesConverte;
import com.campuslands.proyectoSpringBoot.Dto.EnvioSedesDTO;
import com.campuslands.proyectoSpringBoot.Services.EnvioSedeService;
import com.campuslands.proyectoSpringBoot.repositories.EnvioSedesRepository;
import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioSedesEntity;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class EnvioSedeServiceImpl implements EnvioSedeService{
    @Autowired
    private EnvioSedesRepository envioSedesRepository;
    @Autowired
    private EnvioSedesConverte envioSedesConverte;

    @Override
    @Transactional(readOnly = true)
    public EnvioSedesDTO findById(Long id) {
        Optional<EnvioSedesEntity> envioOptional = envioSedesRepository.findById(id);
        if (envioOptional.isPresent()) {
            EnvioSedesEntity envioSedesEntity = envioOptional.get();
            return envioSedesConverte.envioSedesDTO(envioSedesEntity);
        }
        return null;
    }

    @Override
    @Transactional
    public EnvioSedesDTO save(EnvioSedesDTO envioSedes) {
        EnvioSedesEntity envio = envioSedesConverte.converterSedesEntity(envioSedes);
        envioSedesRepository.save(envio);
        return envioSedesConverte.envioSedesDTO(envio);
    }

    @Override
    public void delete(Long id) {
        envioSedesRepository.deleteById(id);
    }

    @Override
    public EnvioSedesDTO update(Long id, EnvioSedesDTO envioSedes) {
        Optional<EnvioSedesEntity> envioCurrentOptional = envioSedesRepository.findById(id);
        if (envioCurrentOptional.isPresent()) {
            EnvioSedesEntity envioCurrent = envioSedesConverte.converterSedesEntity(envioSedes);
            envioCurrent.setIdEnvioSedes(id);
            envioCurrent.setIdEnvio(envioCurrent.getIdEnvio());
            envioCurrent.setIdSede(envioCurrent.getIdSede());

            envioSedesRepository.save(envioCurrent);

            return envioSedesConverte.envioSedesDTO(envioCurrent);
        }
        return null;
    }

}
