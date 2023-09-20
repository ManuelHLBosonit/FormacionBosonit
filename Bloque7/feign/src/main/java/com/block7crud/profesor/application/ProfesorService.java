package com.block7crud.profesor.application;

import com.block7crud.profesor.domain.Profesor;
import com.block7crud.profesor.infrastructure.dto.ProfesorInputDto;
import com.block7crud.profesor.infrastructure.dto.ProfesorOutputDto;

import java.util.List;

public interface ProfesorService {
    Profesor getProfesorById(String id);

    ProfesorOutputDto addProfesor(ProfesorInputDto teacherInputDto);
}
