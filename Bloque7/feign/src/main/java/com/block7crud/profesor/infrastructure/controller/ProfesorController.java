package com.block7crud.profesor.infrastructure.controller;

import com.block7crud.profesor.application.ProfesorService;
import com.block7crud.profesor.application.ProfesorServiceImpl;
import com.block7crud.profesor.domain.ProfesorMapper;
import com.block7crud.profesor.infrastructure.dto.ProfesorInputDto;
import com.block7crud.profesor.infrastructure.dto.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("profesor")
public class ProfesorController {
    @Autowired
    ProfesorService profesorService;

    @PostMapping()
    public ResponseEntity<ProfesorOutputDto> addProfesor(@RequestBody ProfesorInputDto profesorInputDto){
        return ResponseEntity.ok().body(profesorService.addProfesor(profesorInputDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorOutputDto> getProfesor(@PathVariable String id){
        return ResponseEntity.ok().body(profesorService.getProfesorById(id).profesorToProfesorOutput());
    }
}
