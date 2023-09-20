package com.block7crud.profesor.application;

import com.block7crud.persona.domain.Persona;
import com.block7crud.persona.infrastructure.repository.PersonaRepository;
import com.block7crud.profesor.domain.Profesor;
import com.block7crud.profesor.domain.ProfesorMapper;
import com.block7crud.profesor.infrastructure.dto.ProfesorInputDto;
import com.block7crud.profesor.infrastructure.dto.ProfesorOutputDto;
import com.block7crud.profesor.infrastructure.repository.ProfesorRepository;
import com.block7crud.student.domain.Student;
import com.block7crud.student.infrastructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService{
    /*
    Tener en cuenta que UNA persona solo puede ser o profesor o estudiante.

    -En TODOS los endpoints de búsqueda de la entidad persona (por ID, por nombre o todas las personas),
     aceptar un parámetro que indique si debe devolver solo los datos de la persona o también los de es-
     tudiante o profesor si fuera alguno de ellos.

     */

    @Autowired
    PersonaRepository personRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Profesor addProfesor(ProfesorInputDto profesorInputDto) {
        Persona person = personRepository.findById(profesorInputDto.getId_persona()).orElseThrow(
                () -> new NotFoundException("La id " + profesorInputDto.getId_persona() + " no se ha podido encontrar")
        );
        if (person.getStudent() != null && person.getStudent().getId_student() != null) new NotFoundException("Esta persona ya tiene un estudiante asignado");
        Profesor profesor = ProfesorMapper.INSTANCE.profesorInputDtoToProfesor(profesorInputDto);

        person.setProfesor(profesor);
        profesor.setPersona(person);

        return profesorRepository.save(profesor);

    }

    @Override
    public Profesor getProfesorById(String id) {
        return profesorRepository.findById(id).orElseThrow(
                () -> new NotFoundException("La id " + id + " no se ha podido encontrar")
        );
    }

    @Override
    public List<ProfesorOutputDto> getAllProfesores() {
        return profesorRepository.findAll().stream().map(Profesor::profesorToProfesorOutput).toList();
    }



    @Override
    public void addStudent(String id_student, String id_profesor) {
        Student student = studentRepository.findById(id_student).orElseThrow(
                () -> new NotFoundException("La id " + id_student + " no se ha podido encontrar")
        );
        Profesor profesor = profesorRepository.findById(id_profesor).orElseThrow(
                () -> new NotFoundException("La id " + id_profesor + " no se ha podido encontrar")
        );

        student.setProfesor(profesor);
        profesor.getStudents().add(student);

        studentRepository.save(student);
        profesorRepository.save(profesor);
    }
}
