package com.campuslands.proyectoSpringBoot.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campuslands.proyectoSpringBoot.Dto.CuotaDTO;
import com.campuslands.proyectoSpringBoot.Services.CuotaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/cuotas")
public class CuotaController {
    @Autowired
    private CuotaService cuotaService;

    @GetMapping("/")
    public List<CuotaDTO> findAll(){
        return cuotaService.findAll();
    }

    public CuotaDTO save(@RequestBody  CuotaDTO cuota){
        return cuotaService.save(cuota);
    }
}
