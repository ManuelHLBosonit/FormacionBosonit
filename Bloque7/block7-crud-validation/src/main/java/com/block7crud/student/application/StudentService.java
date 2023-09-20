package com.block7crud.student.application;

import com.block7crud.asignatura.infrastructure.dto.AsignaturaOutputDto;
import com.block7crud.persona.domain.Persona;
import com.block7crud.persona.infrastructure.dto.PersonaOutputDto;
import com.block7crud.student.domain.Student;
import com.block7crud.student.infrastructure.dto.StudentInputDto;
import com.block7crud.student.infrastructure.dto.StudentOutputDto;
import org.webjars.NotFoundException;

import java.util.List;

public interface StudentService {

    Student addStudent(StudentInputDto student) throws Exception;

    Student modifyStudent(StudentInputDto student) throws NotFoundException;

    String deleteById(String id);

    Student searchById(String id);

    Iterable<StudentOutputDto> getAllStudents();

    void addStudentToAsignatura(String id_student, String id_asignatura);

    List<AsignaturaOutputDto> getAsignaturasByStudentId(String id);

    void asignarAsignaturasEstudiante(String id_student, List<String> id_asignatura);

    void desasignarAsignaturasEstudiante(String id_student, List<String> id_asignatura);
}
