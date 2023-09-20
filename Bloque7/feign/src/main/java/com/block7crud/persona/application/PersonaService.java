package com.block7crud.persona.application;

import com.block7crud.persona.domain.Persona;
import com.block7crud.persona.infrastructure.dto.PersonaInputDto;
import com.block7crud.persona.infrastructure.dto.PersonaOutputDto;

public interface PersonaService {

    PersonaOutputDto addPerson(PersonaInputDto personInputDto);
}

