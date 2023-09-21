package com.block10dockerizeapp.infrastructure.controller;

import com.block10dockerizeapp.application.CocheServiceImpl;
import com.block10dockerizeapp.domain.CocheMapper;
import com.block10dockerizeapp.infrastructure.dto.CocheInputDto;
import com.block10dockerizeapp.infrastructure.dto.CocheOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("coche")
public class CocheController {

    @Autowired
    CocheServiceImpl cocheService;
    @PostMapping
    public ResponseEntity<CocheOutputDto> addCoche(@RequestBody CocheInputDto cocheInputDto){
        return ResponseEntity.ok().body(CocheMapper.INSTANCE.CocheToCocheOutputDto(cocheService.addCoche(CocheMapper.INSTANCE.cocheInputDtoToCoche(cocheInputDto))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CocheOutputDto> getCocheById(@PathVariable String id){
        return ResponseEntity.ok().body(CocheMapper.INSTANCE.CocheToCocheOutputDto(cocheService.getCocheById(id)));
    }
}
