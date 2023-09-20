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

@RestController
@RequestMapping("persona")
public class PersonaController {
    @Autowired
    private ProfesorFeignClient profesorFeignClient;

    @GetMapping("/profesor/{id}")
    public ProfesorOutputDto getProfesor(@PathVariable String id) {
        return profesorFeignClient.getProfesor(id);
    }
    @Autowired
    PersonaService personaService;

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

    @GetMapping("/{id}")
    public ResponseEntity<?> searchById(@PathVariable String id){
        return ResponseEntity.ok().body(personaService.searchById(id));
    }

    @GetMapping("nombre/{nombre}")
    public Iterable<PersonaOutputDto> searchByName(@PathVariable String nombre){
        return personaService.getByName(nombre);
    }

    @GetMapping
    public Iterable<?> getAll(){
        return personaService.getAll();
    }
}
