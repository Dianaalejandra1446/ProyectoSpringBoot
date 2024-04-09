package com.campuslands.proyectoSpringBoot.Services.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campuslands.proyectoSpringBoot.Configuracion.EnvioAyudaHumanitariaConverte;
import com.campuslands.proyectoSpringBoot.Dto.EnvioAyudaHumanitariaDTO;
import com.campuslands.proyectoSpringBoot.Services.EnvioAyudaHumanitariaService;
import com.campuslands.proyectoSpringBoot.repositories.EnvioAyudaHumanitariaRepository;
import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioAyudaHumanitariaEntity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EnvioAyudaHumanitariaServiceImpl implements EnvioAyudaHumanitariaService {

    @Autowired
    private EnvioAyudaHumanitariaRepository envioAyudaHumanitariaRepository;
    
    @Autowired
    private EnvioAyudaHumanitariaConverte envioAyudaHumanitariaConverte;
    
    
    @Override
    @Transactional(readOnly = true)
    public EnvioAyudaHumanitariaDTO findById(Long id) {
        Optional<EnvioAyudaHumanitariaEntity> envioOptional = envioAyudaHumanitariaRepository.findById(id);
        if (envioOptional.isPresent()) {
            EnvioAyudaHumanitariaEntity envioAyudaHumanitariaEntity = envioOptional.get();
            return envioAyudaHumanitariaConverte.converterEnvioAyudaHumanitariaDTO(envioAyudaHumanitariaEntity);
        }
        return null;
    }
    @Override
    public EnvioAyudaHumanitariaDTO save(EnvioAyudaHumanitariaDTO envioAyudaHumanitaria) {
        EnvioAyudaHumanitariaEntity envio = envioAyudaHumanitariaConverte.converterDTOAyudaHumanitariaEntity(envioAyudaHumanitaria);
        envioAyudaHumanitariaRepository.save(envio);
        return envioAyudaHumanitariaConverte.converterEnvioAyudaHumanitariaDTO(envio);
    }
    @Override
    public void delete(Long id) {
        envioAyudaHumanitariaRepository.deleteById(id);
    }
    @Override
    public EnvioAyudaHumanitariaDTO update(Long id, EnvioAyudaHumanitariaDTO envioAyudaHumanitaria) {
        Optional<EnvioAyudaHumanitariaEntity> envioCurrentOptional = envioAyudaHumanitariaRepository.findById(id);
        if (envioCurrentOptional.isPresent()) {
            EnvioAyudaHumanitariaEntity envioCurrent = envioAyudaHumanitariaConverte.converterDTOAyudaHumanitariaEntity(envioAyudaHumanitaria);
            envioCurrent.setIdAyudaHumanitaria(id);
            envioCurrent.setNumVoluntarios(envioAyudaHumanitaria.getNumVoluntarios());
            envioCurrent.setIdVoluntariados(envioCurrent.getIdVoluntariados());

            envioAyudaHumanitariaRepository.save(envioCurrent);

            return envioAyudaHumanitariaConverte.converterEnvioAyudaHumanitariaDTO(envioCurrent);

        }
        return null;
    }



}
