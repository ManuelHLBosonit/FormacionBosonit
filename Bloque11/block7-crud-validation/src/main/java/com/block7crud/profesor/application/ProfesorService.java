package com.block7crud.profesor.application;

import com.block7crud.profesor.domain.Profesor;
import com.block7crud.profesor.infrastructure.dto.ProfesorInputDto;
import com.block7crud.profesor.infrastructure.dto.ProfesorOutputDto;

import java.util.List;

public interface ProfesorService {
    Profesor addProfesor(ProfesorInputDto profesorInputDto);

    Profesor getProfesorById(String id);

    List<ProfesorOutputDto> getAllProfesores();

    void addStudent(String id_student, String id_profesor);
}
