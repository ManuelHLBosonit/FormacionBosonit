package com.block7crud.persona.application;

import com.block7crud.asignatura.domain.Asignatura;
import com.block7crud.error.Unprocessable;
import com.block7crud.persona.domain.Persona;
import com.block7crud.persona.domain.PersonaMapper;
import com.block7crud.persona.infrastructure.dto.PersonaOutputDto;
import com.block7crud.persona.infrastructure.repository.PersonaRepository;
import com.block7crud.profesor.domain.Profesor;
import com.block7crud.profesor.infrastructure.repository.ProfesorRepository;
import com.block7crud.student.domain.Student;
import com.block7crud.student.infrastructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    @Override
    public Persona addPersona(Persona persona) throws Exception {
        if (comprobar(persona)) return personaRepository.save(persona);
        return null;
    }

    @Override
    public Persona modifyPeron(Persona persona) throws NotFoundException {
        personaRepository.findById(persona.getId_persona()).ifPresentOrElse(
                existe -> {
                    personaRepository.save(persona);
                },
                () -> {
                    throw new NotFoundException("La id " + persona.getId_persona() + " no se ha podido encontrar");
                }
        );
        return persona;
    }

    @Override
    public String deleteById(String id) {

        Persona persona = personaRepository.findById(id).orElseThrow(
                () -> {
                    throw new NotFoundException("La id " + id + " no se ha podido encontrar");
                }
        );
        //Si tiene profesor
        if (persona.getProfesor() != null){
            Profesor profesor = persona.getProfesor();

            Set<Student> estudiantes =  profesor.getStudents();

            // Establecer la referencia del Profesor a null en los Estudiantes
            for (Student estudiante : estudiantes) {
                estudiante.setProfesor(null);
                studentRepository.save(estudiante);
            }
        }
        if (persona.getStudent() != null){
            Student student = persona.getStudent();

                if (student.getProfesor() != null){
                    //Eliminamos la referencia con profesor
                    Profesor profesor = student.getProfesor();
                    profesor.getStudents().remove(student);
                    profesorRepository.save(profesor);
                }

            //Eliminamos las asignaturas que tiene
            Set<Asignatura> asignaturas = student.getAsignaturas();
            student.getAsignaturas().removeAll(asignaturas);
            studentRepository.save(student);
        }
        personaRepository.deleteById(id);
        return "Id " + id + " eliminado correctamente";
    }


    @Override
    public Persona searchById(String id) {
        Persona persona = personaRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("La id " + id + " no se ha podido encontrar");
        });

        return persona;
    }


    @Override
    public Iterable<?> getByName(String name, String op) {
        return personaRepository.findByNameLike("%" + name + "%").stream().map(per -> {
                    Object perso = null;
                    if (op.equals("full")) {
                        if (per.getStudent() != null && per.getStudent().getId_student() != null)
                            return per.personaStudentOutputDto();
                        if (per.getProfesor() != null && per.getProfesor().getId_profesor() != null)
                            return per.personaProfesorOutputDto();
                    }
                    perso = PersonaMapper.INSTANCE.PersonaToPersonaOutputDto(per);
                    return perso;
                }
        ).toList();
    }

    @Override
    public Iterable<?> getAll(String op) {
        return personaRepository.findAll().stream().map(per -> {
            Object perso = null;
            if (op.equals("full")) {
                if (per.getStudent() != null && per.getStudent().getId_student() != null)
                    return per.personaStudentOutputDto();
                if (per.getProfesor() != null && per.getProfesor().getId_profesor() != null)
                    return per.personaProfesorOutputDto();
            }
            perso = PersonaMapper.INSTANCE.PersonaToPersonaOutputDto(per);
            return perso;
        }
        ).toList();
    }

    public boolean comprobar(Persona persona) throws Exception {
        HttpHeaders headers = new HttpHeaders();

        if (persona.getUsuario() == null) {
            throw new Unprocessable("Usuario no puede ser nulo"); }
        if (persona.getName().length() > 10) {
             throw new Unprocessable("Longitud de usuario no puede ser superior a 10 caracteres");
        }
        if (persona.getName().length() < 6) {
             throw new Unprocessable("Longitud de usuario no puede ser menor a 6 caracteres");
        }
        if (persona.getPassword() == null) {
             throw new Unprocessable("La contraseña no puede ser null");
        }
        if (persona.getName() == null) {
             throw new Unprocessable("El nombre no puede ser null");
        }
        if (persona.getCompany_email() == null) {
             throw new Unprocessable("El email de la compañia no puede ser null");
        }
        if (persona.getPersonal_email() == null) {
             throw new Unprocessable("El email de personal no puede ser null");
        }
        if (persona.getCity() == null) {
             throw new Unprocessable("La ciudad no puede ser null");
        }
        try {
            persona.isActive();
        } catch (Exception e) {
             throw new Unprocessable("El campo activo no puede ser null");
        }
        if (persona.getCreated_date() == null) {
             throw new Unprocessable("La fechad de creación no puede ser null");
        }
        return true;
    }
}
