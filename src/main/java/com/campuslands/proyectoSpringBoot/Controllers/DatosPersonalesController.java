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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campuslands.proyectoSpringBoot.Dto.DatosPersonalesDTO;
import com.campuslands.proyectoSpringBoot.Services.DatosPersonalesService;

@RestController
@RequestMapping("/datos-personales")
public class DatosPersonalesController {
    @Autowired
    private DatosPersonalesService datosPersonalesService;

    @GetMapping("/ver-datos-personales")
    public List<DatosPersonalesDTO> findAll(){
        return datosPersonalesService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DatosPersonalesDTO> findById(@PathVariable Long id){
        DatosPersonalesDTO datos = datosPersonalesService.findById(id);
        if (datos != null) {
            return new ResponseEntity<>(datos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/agregar-datos-personales")
    public DatosPersonalesDTO save(@RequestBody DatosPersonalesDTO datosPersonales){
        return datosPersonalesService.save(datosPersonales);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Object>> update(@PathVariable Long id, @Validated @RequestBody DatosPersonalesDTO datosPersonalesDTO, BindingResult result){

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
            DatosPersonalesDTO datosUpdate = datosPersonalesService.update(id, datosPersonalesDTO);
          
            response.put("mensaje", "Los datos personales han sido actualizados con éxito");
            response.put("datos_personales", datosUpdate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el update en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
