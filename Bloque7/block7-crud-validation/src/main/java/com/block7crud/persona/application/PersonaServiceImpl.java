package com.block7crud.persona.application;

import com.block7crud.persona.domain.Persona;
import com.block7crud.persona.domain.PersonaMapper;
import com.block7crud.persona.infrastructure.dto.PersonaOutputDto;
import com.block7crud.persona.infrastructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public Persona addPersona(Persona persona) throws Exception {
        if (comprobar(persona)) return personaRepository.save(persona);
        return null;
    }

    @Override
    public Persona modifyPeron(Persona persona) throws NotFoundException {
        personaRepository.findById(persona.getId()).ifPresentOrElse(
                existe -> {
                    personaRepository.save(persona);
                },
                () -> {
                    throw new NotFoundException("La id " + persona.getId() + " no se ha podido encontrar");
                }
        );
        return persona;
    }

    @Override
    public String deleteById(int id) {

        personaRepository.findById(id).ifPresentOrElse(
                existe -> {
                    personaRepository.deleteById(id);

                },
                () -> {
                    throw new NotFoundException("La id " + id + " no se ha podido encontrar");
                }
        );
        return "Id " + id + " eliminado correctamente";
    }


    @Override
    public Persona searchById(int id) {
        return personaRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("La id " + id + " no se ha podido encontrar");
        });
    }


    @Override
    public Iterable<PersonaOutputDto> getByName(String name) {
        return personaRepository.findByNameLike("%" + name + "%").stream()
                .map(per -> PersonaMapper.INSTANCE.PersonaToPersonaOutputDto(per))
                .toList();
    }

    @Override
    public Iterable<PersonaOutputDto> getAll() {
        return personaRepository.findAll().stream().map(per -> PersonaMapper.INSTANCE.PersonaToPersonaOutputDto(per)).toList();
    }

    public boolean comprobar(Persona persona) throws Exception {
        if (persona.getUsuario() == null) {
            throw new Exception("Usuario no puede ser nulo");
        }
        if (persona.getName().length() > 10) {
            throw new Exception("Longitud de usuario no puede ser superior a 10 caracteres");
        }
        if (persona.getName().length() < 6) {
            throw new Exception("Longitud de usuario no puede ser menor a 6 caracteres");
        }
        if (persona.getPassword() == null) {
            throw new Exception("La contraseña no puede ser null");
        }
        if (persona.getName() == null) {
            throw new Exception("El nombre no puede ser null");
        }
        if (persona.getCompany_email() == null) {
            throw new Exception("El email de la compañia no puede ser null");
        }
        if (persona.getPersonal_email() == null) {
            throw new Exception("El email de personal no puede ser null");
        }
        if (persona.getCity() == null) {
            throw new Exception("La ciudad no puede ser null");
        }
        try {
            persona.isActive();
        } catch (Exception e) {
            throw new Exception("El campo activo no puede ser null");
        }
        if (persona.getCreated_date() == null) {
            throw new Exception("La fechad de creación no puede ser null");
        }
        return true;
    }
}
