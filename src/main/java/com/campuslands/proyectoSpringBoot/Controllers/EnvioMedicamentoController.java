package com.campuslands.proyectoSpringBoot.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campuslands.proyectoSpringBoot.Dto.EnvioMedicamentoDTO;
import com.campuslands.proyectoSpringBoot.Services.EnvioMedicamentosService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/envio-medicamentos")
public class EnvioMedicamentoController {

    @Autowired
    private EnvioMedicamentosService envioMedicamentosService;

    @GetMapping("/{id}")
    public ResponseEntity<EnvioMedicamentoDTO> findById(@PathVariable Long id) {
        EnvioMedicamentoDTO envioMedicamento = envioMedicamentosService.findById(id);
        if (envioMedicamento != null) {
            return new ResponseEntity<>(envioMedicamento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/agregar-envios-medicamentos")
    public ResponseEntity<EnvioMedicamentoDTO> save(@Valid @RequestBody EnvioMedicamentoDTO envioMedicamentoDTO) {
        EnvioMedicamentoDTO savedEnvioMedicamento = envioMedicamentosService.save(envioMedicamentoDTO);
        return new ResponseEntity<>(savedEnvioMedicamento, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            envioMedicamentosService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable Long id,
            @Valid @RequestBody EnvioMedicamentoDTO envioMedicamentoDTO, BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        try {
            if (result.hasErrors()) {
                List<String> errors = result.getFieldErrors().stream()
                        .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                        .collect(Collectors.toList());
                response.put("errors", errors);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
            EnvioMedicamentoDTO envioActualizado = envioMedicamentosService.update(id, envioMedicamentoDTO);
            response.put("mensaje", "Los envíos han sido actualizados con éxito");
            response.put("envio_medicamento", envioActualizado);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el update en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
