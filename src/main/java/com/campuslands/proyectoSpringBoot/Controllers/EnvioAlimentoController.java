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

import com.campuslands.proyectoSpringBoot.Dto.EnvioAlimentosDTO;
import com.campuslands.proyectoSpringBoot.Services.EnvioAlimentoService;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/envio-alimentos")
public class EnvioAlimentoController {
    @Autowired
    private EnvioAlimentoService envioAlimentoService;

    @GetMapping("/ver-envio-alimentos")
    public List<EnvioAlimentosDTO> findAll(){
        return envioAlimentoService.findAll();
    }
    @GetMapping("{id}")
    public ResponseEntity<EnvioAlimentosDTO> findById(@PathVariable long id){
        EnvioAlimentosDTO envio = envioAlimentoService.findById(id);
        if (envio != null) {
            return new ResponseEntity<>(envio,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        try {
            envioAlimentoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/agregar-envio")
    public EnvioAlimentosDTO save(@RequestBody EnvioAlimentosDTO envioAlimentosDTO){
        return envioAlimentoService.save(envioAlimentosDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String,Object>> update(@PathVariable Long id,@Validated @RequestBody EnvioAlimentosDTO envioAlimentosDTO,BindingResult result){
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
            EnvioAlimentosDTO envioUpdate = envioAlimentoService.update(id, envioAlimentosDTO);

            response.put("mensaje", "Los envios de alimentos han sido actualizados con éxito");
            response.put("datos_personales", envioUpdate);            
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el update en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
