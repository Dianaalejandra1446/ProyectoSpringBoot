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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campuslands.proyectoSpringBoot.Dto.CuotaDTO;
import com.campuslands.proyectoSpringBoot.Services.CuotaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/cuotas")
public class CuotaController {
    @Autowired
    private CuotaService cuotaService;

    @GetMapping("/ver-cuotas")
    public List<CuotaDTO> findAll(){
        return cuotaService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<CuotaDTO> findById(@PathVariable Long id) {
        CuotaDTO cuota = cuotaService.findById(id);
        if (cuota != null) {
            return new ResponseEntity<>(cuota, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/agregar-cuota")
    public CuotaDTO save(@RequestBody  CuotaDTO cuota){
        return cuotaService.save(cuota);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            cuotaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String,Object>> update(@PathVariable Long id,@Validated @RequestBody CuotaDTO cuotaDTO,BindingResult result ){

        Map<String,Object> response = new HashMap<>();

        try {
            if (result.hasErrors()) {
                List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo "+ err.getField()+ " "+ err.getDefaultMessage())
                    .collect(Collectors.toList());
                response.put("errors", errors);
                return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
            }
            CuotaDTO cuotaUpdate = null;
            cuotaUpdate = cuotaService.update(id, cuotaDTO);

            response.put("menssaje", "La cuota ha sido actualizada con exito");
            response.put("cuota" ,cuotaUpdate);

            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el update en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
