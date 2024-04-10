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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campuslands.proyectoSpringBoot.Dto.SedesDTO;
import com.campuslands.proyectoSpringBoot.Services.SedeService;

@RestController
@RequestMapping("/sedes")
public class SedesController {
    @Autowired
    private SedeService sedeService;

    @GetMapping("/ver-sedes")
    public List<SedesDTO> findAll(){
        return sedeService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<SedesDTO> findById(@PathVariable Long id){
        SedesDTO sedes = sedeService.findById(id);
        if (sedes != null) {
            return new ResponseEntity<>(sedes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/agregar-sedes")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        try {
            sedeService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String,Object>> update(@PathVariable Long id, @Validated @RequestBody SedesDTO sedesDTO, BindingResult result){
        Map<String,Object> response = new HashMap<>();
        try {
            if (result.hasErrors()) {
                List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo "+ err.getField()+ " "+ err.getDefaultMessage())
                    .collect(Collectors.toList());
                response.put("errors", errors);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);        
            }
            SedesDTO sedesUpdate = sedeService.update(id, sedesDTO);
          
            response.put("mensaje", "Las sedes han sido actualizados con éxito");
            response.put("sedes", sedesUpdate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el update en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }        
}

