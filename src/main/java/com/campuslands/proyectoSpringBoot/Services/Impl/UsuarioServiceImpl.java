package com.campuslands.proyectoSpringBoot.Services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campuslands.proyectoSpringBoot.Configuracion.UsuarioConverte;
import com.campuslands.proyectoSpringBoot.Dto.UsuarioDTO;
import com.campuslands.proyectoSpringBoot.Services.UsuarioService;
import com.campuslands.proyectoSpringBoot.repositories.UsuarioRepository;
import com.campuslands.proyectoSpringBoot.repositories.entities.Usuario;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioConverte usuarioConverte;

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDTO> findAll() {
        List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
        return usuarios.stream()
                        .map(usuario -> usuarioConverte.convertirUsuarioADTO(usuario))
                        .toList();
    }
    @Override
    @Transactional
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioConverte.convertirDTOAUsuario(usuarioDTO);
        usuarioRepository.save(usuario);
        return usuarioConverte.convertirUsuarioADTO(usuario);
    }

    @Override
    @Transactional
    public UsuarioDTO update(Long id, UsuarioDTO usuarioDTO) {
        Optional<Usuario> usuarioCurrentOptional = usuarioRepository.findById(id);

        if(usuarioCurrentOptional.isPresent()){

            Usuario usuarioCurrent = usuarioConverte.convertirDTOAUsuario(usuarioDTO);
            usuarioCurrent.setId(id);
            usuarioCurrent.setCedula(usuarioDTO.getCedula());

            usuarioRepository.save(usuarioCurrent);

            return usuarioConverte.convertirUsuarioADTO(usuarioCurrent);
        }
        return null;    
    }

    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    
}
