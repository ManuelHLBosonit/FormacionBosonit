package com.block7crud.persona.application;

import com.block7crud.persona.domain.Persona;
import com.block7crud.persona.domain.PersonaMapper;
import com.block7crud.persona.infrastructure.dto.PersonaInputDto;
import com.block7crud.persona.infrastructure.dto.PersonaOutputDto;
import com.block7crud.persona.infrastructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    PersonaRepository personRepository;

    @Override
    public PersonaOutputDto addPerson(PersonaInputDto personInputDto) {
        return PersonaMapper.INSTANCE.PersonaToPersonaOutputDto(personRepository.save((PersonaMapper.INSTANCE.personaInputDtoToPersona(personInputDto))));
    }
}

