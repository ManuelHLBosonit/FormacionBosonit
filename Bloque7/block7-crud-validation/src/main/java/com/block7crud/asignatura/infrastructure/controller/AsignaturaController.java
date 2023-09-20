package com.block7crud.asignatura.infrastructure.controller;

import com.block7crud.asignatura.application.AsignaturaService;
import com.block7crud.asignatura.domain.AsignaturaMapper;
import com.block7crud.asignatura.infrastructure.dto.AsignaturaInputDto;
import com.block7crud.asignatura.infrastructure.dto.AsignaturaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("asignatura")
public class AsignaturaController {

    @Autowired
    AsignaturaService asignaturaService;

    @GetMapping("/{id}")
    public ResponseEntity<AsignaturaOutputDto> getAsignaturaById(@PathVariable String id){
        return ResponseEntity.ok().body(AsignaturaMapper.INSTANCE.AsignaturaToAsignaturaOutputDto(asignaturaService.getAsignaturaById(id)));
    }

    @GetMapping()
    public Iterable<AsignaturaOutputDto> getAllAsignaturas(){
        return asignaturaService.getAllAsignaturas();
    }
    @PostMapping()
    public ResponseEntity<AsignaturaOutputDto> addAsignatura(@RequestBody AsignaturaInputDto asignaturaInputDto){
        return ResponseEntity.ok().body(AsignaturaMapper.INSTANCE.AsignaturaToAsignaturaOutputDto(asignaturaService.addAsignatura(AsignaturaMapper.INSTANCE.asignaturaInputDtoToAsignatura(asignaturaInputDto))));
    }

    @PutMapping()
    public ResponseEntity<AsignaturaOutputDto> updateAsignatura(@RequestBody AsignaturaInputDto asignaturaInputDto){
        return ResponseEntity.ok().body(AsignaturaMapper.INSTANCE.AsignaturaToAsignaturaOutputDto(asignaturaService.updateAsignatura(AsignaturaMapper.INSTANCE.asignaturaInputDtoToAsignatura(asignaturaInputDto))));
    }

}
