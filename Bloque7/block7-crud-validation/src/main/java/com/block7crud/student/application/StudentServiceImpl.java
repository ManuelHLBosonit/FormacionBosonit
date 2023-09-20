package com.block7crud.student.application;

import com.block7crud.asignatura.domain.Asignatura;
import com.block7crud.asignatura.domain.AsignaturaMapper;
import com.block7crud.asignatura.infrastructure.dto.AsignaturaOutputDto;
import com.block7crud.asignatura.infrastructure.repository.AsignaturaRepository;
import com.block7crud.persona.domain.Persona;
import com.block7crud.persona.infrastructure.repository.PersonaRepository;
import com.block7crud.student.domain.Student;
import com.block7crud.student.domain.StudentMapper;
import com.block7crud.student.infrastructure.dto.StudentInputDto;
import com.block7crud.student.infrastructure.dto.StudentOutputDto;
import com.block7crud.student.infrastructure.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PersonaRepository personRepository;

    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Override
    public Student addStudent(StudentInputDto student) throws Exception {
        Persona person = personRepository
                .findById(student.getId_persona())
                .orElseThrow(
                        () -> new NotFoundException("No se encuentra la ID de la persona")
                );
        if (person.getProfesor() != null && person.getProfesor().getId_profesor() != null) new NotFoundException("Esta persona ya tiene un profesor asignado");

        Student student1 = StudentMapper.INSTANCE.studentInputDtoToStudent(student);

        person.setStudent(student1);
        student1.setPersona(person);
        return studentRepository.save(student1);
    }

    @Override
    public Student modifyStudent(StudentInputDto student) throws NotFoundException {
        Persona persona = getPersonById(student.getId_persona());
        Student student1 = StudentMapper.INSTANCE.studentInputDtoToStudent(student);
        studentRepository.findById(student.getId_student()).ifPresentOrElse(
                existe -> {
                    student1.setPersona(persona);
                   studentRepository.save(student1);
                },
                () -> {
                    throw new NotFoundException("La id " + student.getId_student() + " no se ha podido encontrar");
                }
        );
        return student1;
    }

    @Override
    public String deleteById(String id) {
        studentRepository.findById(id).ifPresentOrElse(
                existe -> {
                    personRepository.findById(existe.getPersona().getId_persona()).ifPresentOrElse(
                            encontrado -> {
                                encontrado.setStudent(null);
                                personRepository.save(encontrado);
                                studentRepository.deleteById(id);
                            },
                            () -> {
                                throw new NotFoundException("La id " + id + " no se ha podido encontrar");
                            }
                    );

                },
                () -> {
                    throw new NotFoundException("La id " + id + " no se ha podido encontrar");
                }
        );
        return "Id " + id + " eliminado correctamente";
    }


    @Override
    public Student searchById(String id) {
        return studentRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("La id " + id + " no se ha podido encontrar");
        });
    }

    @Override
    public Iterable<StudentOutputDto> getAllStudents() {
        return studentRepository.findAll().stream().map(Student :: studentToStudentOutputDto).toList();
    }

    public Persona getPersonById(String id){
        return personRepository.findById(id).orElseThrow( () -> {
            throw new NotFoundException("La id " + id + " no se ha podido encontrar");
        });
    }
    @Override
    public void addStudentToAsignatura(String id_student, String id_asignatura) {
        Student student = studentRepository.findById(id_student).orElseThrow(
                () -> new NotFoundException("La id " + id_asignatura + " no se ha podido encontrar")
        );

        Asignatura asignatura = asignaturaRepository.findById(id_asignatura).orElseThrow(
                () -> new NotFoundException("La id " + id_asignatura + " no se ha podido encontrar")
        );

        student.getAsignaturas().add(asignatura);
        studentRepository.save(student);
    }

    @Override
    public List<AsignaturaOutputDto> getAsignaturasByStudentId(String id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("La id " + id + " no se ha podido encontrar"));

        return student.getAsignaturas()
                .stream()
                .map(pe -> AsignaturaMapper.INSTANCE.AsignaturaToAsignaturaOutputDto(pe)).toList();
    }

    @Override
    public void asignarAsignaturasEstudiante(String id_student, List<String> id_asignatura) {
        Student student = studentRepository.findById(id_student).orElseThrow(
                () -> new EntityNotFoundException("No se encuentra la ID del alumno")
        );

        List<Asignatura> asignaturas = asignaturaRepository.findAllById(id_asignatura);

        for (Asignatura asignatura : asignaturas) {
            asignatura.getStudents().add(student);
        }


        asignaturaRepository.saveAll(asignaturas);

    }

    @Override
    public void desasignarAsignaturasEstudiante(String id_student, List<String> id_asignatura) {
        Student student = studentRepository.findById(id_student).orElseThrow(
                () -> new NotFoundException("La id " + id_asignatura + " no se ha podido encontrar")
        );

        List<Asignatura> asignaturas = asignaturaRepository.findAllById(id_asignatura);

        for (Asignatura asignatura : asignaturas) {
            asignatura.getStudents().remove(student);
        }

        asignaturaRepository.saveAll(asignaturas);

    }


}
