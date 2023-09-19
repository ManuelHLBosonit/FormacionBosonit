package com.block7crud.persona.application;

import com.block7crud.persona.domain.Persona;
import com.block7crud.persona.infrastructure.dto.PersonaOutputDto;

public interface PersonaService {
    Persona addPersona(Persona persona);

    Persona modifyPeron(Persona persona);

    String deleteById(int id);

    Persona searchById(int id);

    Iterable<PersonaOutputDto> getByName(String name);

    Iterable<PersonaOutputDto> getAll();
}
