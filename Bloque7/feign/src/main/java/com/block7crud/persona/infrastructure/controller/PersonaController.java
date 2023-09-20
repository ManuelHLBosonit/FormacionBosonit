package com.block7crud.persona.infrastructure.controller;

import com.block7crud.persona.application.PersonaService;
import com.block7crud.persona.infrastructure.dto.PersonaInputDto;
import com.block7crud.persona.infrastructure.dto.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("persona")
public class PersonaController {
    @Autowired
    PersonaService personService;

    @PostMapping
    public ResponseEntity<PersonaOutputDto> addPerson(@RequestBody PersonaInputDto personInputDto){
        return ResponseEntity.ok().body(personService.addPerson(personInputDto));
    }
}
