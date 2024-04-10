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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;

import com.campuslands.proyectoSpringBoot.Dto.EnvioAyudaMaterialDTO;
import com.campuslands.proyectoSpringBoot.Services.EnvioAyudaMaterialService;



@RestController
@RequestMapping("envio-ayuda-material")
public class EnvioAyudaMaterialController {
    @Autowired
    private EnvioAyudaMaterialService envioAyudaMaterialService;

    @GetMapping("/informe")
    public ResponseEntity<List<EnvioAyudaMaterialDTO>> findAll() {
        List<EnvioAyudaMaterialDTO> envios = envioAyudaMaterialService.findAll();
        if (!envios.isEmpty()) {
            return new ResponseEntity<>(envios, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvioAyudaMaterialDTO> findById(@PathVariable long id){
        EnvioAyudaMaterialDTO envio =envioAyudaMaterialService.findById(id);
        if (envio != null) {
            return new ResponseEntity<>(envio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }        
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        try {
            envioAyudaMaterialService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/agregar-envio-ayuda-material")
    public EnvioAyudaMaterialDTO save(@RequestBody EnvioAyudaMaterialDTO envioAyudaMaterialDTO){
        return envioAyudaMaterialService.save(envioAyudaMaterialDTO);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Map<String,Object>>update(@PathVariable Long id,@Validated @RequestBody EnvioAyudaMaterialDTO envioAyudaMaterialDTO,BindingResult result){
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
            EnvioAyudaMaterialDTO envioUpdate = envioAyudaMaterialService.update(id, envioAyudaMaterialDTO);
            response.put("mensaje", "Los envios de material han sido actualizado con éxito");
            response.put("envio_ayuda_material", envioUpdate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el update en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }                                 
    }
}
