package com.block7crud.persona.application;

import com.block7crud.persona.domain.Persona;
import com.block7crud.persona.infrastructure.dto.PersonaOutputDto;

public interface PersonaService {
    Persona addPersona(Persona persona) throws Exception;

    Persona modifyPeron(Persona persona);


    String deleteById(String id);

    Persona searchById(String id);

    Iterable<PersonaOutputDto> getByName(String name);

    Iterable<?> getAll();
}
