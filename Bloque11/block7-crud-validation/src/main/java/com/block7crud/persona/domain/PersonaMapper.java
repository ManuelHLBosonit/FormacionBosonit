package com.block7crud.persona.domain;

import com.block7crud.persona.infrastructure.dto.PersonaInputDto;
import com.block7crud.persona.infrastructure.dto.PersonaOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonaMapper {
    PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);

    Persona personaInputDtoToPersona (PersonaInputDto personInputDto);

    PersonaOutputDto PersonaToPersonaOutputDto (Persona persona);
}
