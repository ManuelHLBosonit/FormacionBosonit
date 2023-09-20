package com.block7crud.profesor.application;

import com.block7crud.persona.domain.Persona;
import com.block7crud.persona.infrastructure.repository.PersonaRepository;
import com.block7crud.profesor.domain.Profesor;
import com.block7crud.profesor.domain.ProfesorMapper;
import com.block7crud.profesor.infrastructure.dto.ProfesorInputDto;
import com.block7crud.profesor.infrastructure.dto.ProfesorOutputDto;
import com.block7crud.profesor.infrastructure.repository.ProfesorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService{
    @Autowired
    ProfesorRepository teacherRepository;

    @Autowired
    PersonaRepository personRepository;
    @Override
    public Profesor getProfesorById(String id) {
        return teacherRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No se encuentra la ID")
        );
    }

    @Override
    public ProfesorOutputDto addProfesor(ProfesorInputDto profesorInputDto) {
        Persona person = personRepository.findById(profesorInputDto.getId_persona()).orElseThrow();

        Profesor profesor = ProfesorMapper.INSTANCE.profesorInputDtoToProfesor(profesorInputDto);

        person.setProfesor(profesor);
        profesor.setPersona(person);

        return teacherRepository.save(profesor).profesorToProfesorOutput();
    }
}
