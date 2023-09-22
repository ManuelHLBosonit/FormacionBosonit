package com.block7crud.persona.application;

import com.block7crud.persona.domain.Persona;
import com.block7crud.persona.infrastructure.dto.PersonaOutputDto;

public interface PersonaService {
    Persona addPersona(Persona persona) throws Exception;

    Persona modifyPeron(Persona persona);


    String deleteById(String id);

    Persona searchById(String id);

    Iterable<?> getByName(String name, String op);

    Iterable<?> getAll(String op);
}
