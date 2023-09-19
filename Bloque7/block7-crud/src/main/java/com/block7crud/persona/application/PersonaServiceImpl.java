package com.block7crud.persona.application;

import com.block7crud.persona.domain.Persona;
import com.block7crud.persona.domain.PersonaMapper;
import com.block7crud.persona.infrastructure.dto.PersonaOutputDto;
import com.block7crud.persona.infrastructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public Persona addPersona(Persona persona) {
        System.out.println(persona.getId());
        System.out.println(persona.getNombre());
        System.out.println(persona.getEdad());
        return personaRepository.save(persona);
    }

    @Override
    public Persona modifyPeron(Persona persona) throws NotFoundException {
        personaRepository.findById(persona.getId()).ifPresentOrElse(
                existe -> {
                    if(persona.getEdad() == 0)persona.setEdad(existe.getEdad());
                    if(persona.getNombre() == null)persona.setNombre(existe.getNombre());
                    if(persona.getPoblacion() == null)persona.setPoblacion(existe.getPoblacion());
                    personaRepository.save(persona);
                },
                () -> {throw new NotFoundException("La id " + persona.getId() + " no se ha podido encontrar");}
        );
        return persona;
    }

    @Override
    public String deleteById(int id) {

        personaRepository.findById(id).ifPresentOrElse(
                existe -> {
                    personaRepository.deleteById(id);

                },
                () -> {throw new NotFoundException("La id " + id + " no se ha podido encontrar");}
        );
       return "Id " + id +" eliminado correctamente";
    }


    @Override
    public Persona searchById(int id) {
        return personaRepository.findById(id).orElseThrow( () -> {throw new NotFoundException("La id " + id + " no se ha podido encontrar");});
    }


    @Override
    public Iterable<PersonaOutputDto> getByName(String name) {
        return personaRepository.findByNombreLike("%"+name+"%").stream()
                .map(per -> PersonaMapper.INSTANCE.PersonaToPersonaOutputDto(per))
                .toList();
    }

    @Override
    public Iterable<PersonaOutputDto> getAll(){
        return personaRepository.findAll().stream().map(per -> PersonaMapper.INSTANCE.PersonaToPersonaOutputDto(per)).toList();
    }
}
