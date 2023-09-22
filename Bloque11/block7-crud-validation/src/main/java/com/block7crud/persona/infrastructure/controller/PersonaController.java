package com.block7crud.persona.infrastructure.controller;

import com.block7crud.persona.application.PersonaService;
import com.block7crud.persona.application.PersonaServiceImpl;
import com.block7crud.persona.domain.Persona;
import com.block7crud.persona.domain.PersonaMapper;
import com.block7crud.persona.infrastructure.dto.PersonaInputDto;
import com.block7crud.persona.infrastructure.dto.PersonaOutputDto;
import com.block7crud.profesor.domain.ProfesorFeignClient;
import com.block7crud.profesor.infrastructure.dto.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("persona")
public class PersonaController {
    @Autowired
    private ProfesorFeignClient profesorFeignClient;

    @Autowired
    PersonaServiceImpl personaService;

    //Ejericicio 4
    @GetMapping("/profesor/{id}")
    public ProfesorOutputDto getProfesor(@PathVariable String id) {
        return profesorFeignClient.getProfesor(id);
    }


    //Get
    @GetMapping("/{id}")
    public ResponseEntity<?> searchById(@PathVariable String id, @RequestParam(defaultValue = "simple") String ouputType){
        Persona persona = personaService.searchById(id);
        return ResponseEntity.ok().body(comprobar(persona, ouputType));
    }

    private Object comprobar(Persona persona, String ouputType) {
        if (ouputType.equals("full")){
            if (persona.getStudent() != null) return persona.personaStudentOutputDto();
            if (persona.getProfesor() != null) return persona.personaStudentOutputDto();
        }
        return PersonaMapper.INSTANCE.PersonaToPersonaOutputDto(persona);
    }

    @GetMapping("nombre/{nombre}")
    public Iterable<?> searchByName(@PathVariable String nombre, @RequestParam(defaultValue = "simple") String ouputType){
        return personaService.getByName(nombre, ouputType);
    }


    @GetMapping
    public Iterable<?> getAll(@RequestParam(defaultValue = "simple") String ouputType){
        return personaService.getAll(ouputType);
    }


    @PostMapping
    public ResponseEntity<PersonaOutputDto> addPersona(@RequestBody PersonaInputDto personaInputDto) throws Exception {
       //Transformamos la persona
        Persona persona = personaService.addPersona(PersonaMapper.INSTANCE.personaInputDtoToPersona(personaInputDto));
        //Transformamos la persona en un PersonaOutputDto
        return ResponseEntity.status(HttpStatus.CREATED).body(PersonaMapper.INSTANCE.PersonaToPersonaOutputDto(persona));
    }

    @PutMapping
    public ResponseEntity<PersonaOutputDto> modifyPerson(@RequestBody PersonaInputDto personaInputDto){
        Persona persona = personaService.modifyPeron(PersonaMapper.INSTANCE.personaInputDtoToPersona(personaInputDto));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(PersonaMapper.INSTANCE.PersonaToPersonaOutputDto(persona));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable String id){
        String respuesta = personaService.deleteById(id);
        return ResponseEntity.ok().body(respuesta);
    }


}
