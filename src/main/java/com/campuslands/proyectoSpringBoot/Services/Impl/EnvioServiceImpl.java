package com.campuslands.proyectoSpringBoot.Services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campuslands.proyectoSpringBoot.Configuracion.EnvioConverte;
import com.campuslands.proyectoSpringBoot.Dto.EnvioDTO;
import com.campuslands.proyectoSpringBoot.Services.EnvioService;
import com.campuslands.proyectoSpringBoot.repositories.EnvioRepository;
import com.campuslands.proyectoSpringBoot.repositories.entities.EnvioEntity;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class EnvioServiceImpl implements EnvioService   {
    @Autowired
    private EnvioRepository envioRepository;
    @Autowired
    private EnvioConverte envioConverte;

    @Override
    @Transactional(readOnly = true)
    public List<EnvioDTO> findAll() {
        List<EnvioEntity> envios = (List<EnvioEntity>) envioRepository.findAll();
        return envios.stream()
                     .map(envio -> envioConverte.converterEnvioDTO(envio))
                     .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public EnvioDTO findById(Long id) {
        Optional<EnvioEntity> envioOptional = envioRepository.findById(id);
        if (envioOptional.isPresent()) {
            EnvioEntity envioEntity = envioOptional.get();
            return envioConverte.converterEnvioDTO(envioEntity);
        }
        return null;
    }

    @Override
    @Transactional
    public EnvioDTO save(EnvioDTO envioDTO) {
        EnvioEntity envio = envioConverte.converteDTOEnvioEntity(envioDTO);
        envioRepository.save(envio);
        return envioConverte.converterEnvioDTO(envio);
    }

    @Override
    public void delete(Long id) {
        envioRepository.deleteById(id);
    }

    @Override
    public EnvioDTO update(Long id, EnvioDTO envioDTO) {
        Optional<EnvioEntity> envioCurrentOptional = envioRepository.findById(id);
        if (envioCurrentOptional.isPresent()) {
            EnvioEntity envioCurrent = envioConverte.converteDTOEnvioEntity(envioDTO);
            envioCurrent.setIdEnvio(id);
            envioCurrent.setCodigoEnvio(envioDTO.getCodigoEnvio());
            envioCurrent.setNombreRefugio(envioDTO.getNombreRefugio());
            envioCurrent.setDestino(envioDTO.getDestino());
            envioCurrent.setFechaSalida(envioDTO.getFechaSalida());

            envioRepository.save(envioCurrent);

            return envioConverte.converterEnvioDTO(envioCurrent);
        }
        return null;
    }

}
