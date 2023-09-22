package com.block7crud.persona.infrastructure.controller;

import com.block7crud.persona.application.PersonaServiceImpl;
import com.block7crud.persona.domain.PersonaMapper;
import com.block7crud.persona.infrastructure.dto.PersonaInputDto;
import com.block7crud.persona.infrastructure.dto.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
        @Autowired
        PersonaServiceImpl personService;

        @CrossOrigin(origins = "https://cdpn.io")
        @PostMapping("/addperson")
        public ResponseEntity<?> addPersonCors(@RequestBody PersonaInputDto personInputDto) throws Exception {
            return ResponseEntity.ok().body(personService.addPersona(PersonaMapper.INSTANCE.personaInputDtoToPersona(personInputDto)));
        }

        @CrossOrigin(origins = "https://cdpn.io")
        @GetMapping("/getall")
        public Iterable<?> getPersons() {
            String op = "";
            return personService.getAll(op);
        }


}
