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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campuslands.proyectoSpringBoot.Dto.VoluntariadosDTO;
import com.campuslands.proyectoSpringBoot.Services.VoluntariadoService;

@RestController
@RequestMapping("/voluntariados")
public class VoluntariadosController {
    @Autowired
    private VoluntariadoService voluntariadoService;

    @GetMapping("/ver-voluntarios")
    public List<VoluntariadosDTO> findAll(){
        return voluntariadoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoluntariadosDTO> findById(@PathVariable Long id){
        VoluntariadosDTO voluntariados = voluntariadoService.findById(id);
        if (voluntariados != null) {
            return new ResponseEntity<>(voluntariados, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }        
    }

    @PostMapping("/agregar-voluntario")
    public VoluntariadosDTO save(@RequestBody VoluntariadosDTO voluntariados){
        return voluntariadoService.save(voluntariados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        try {
            voluntariadoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Map<String,Object>> update(@PathVariable Long id, @Validated @RequestBody VoluntariadosDTO voluntariadosDTO,BindingResult result){
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
            VoluntariadosDTO voluntariadosUpdate = voluntariadoService.update(id, voluntariadosDTO);

            response.put("mensaje", "Los datos personales han sido actualizados con éxito");
            response.put("voluntariados", voluntariadosUpdate);
            return new ResponseEntity<>(response, HttpStatus.OK);

    } catch (DataAccessException e) {
        response.put("mensaje", "Error al realizar el update en la base de datos");
        response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
}