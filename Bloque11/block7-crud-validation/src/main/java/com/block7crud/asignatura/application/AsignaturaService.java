package com.block7crud.asignatura.application;

import com.block7crud.asignatura.domain.Asignatura;
import com.block7crud.asignatura.infrastructure.dto.AsignaturaInputDto;
import com.block7crud.asignatura.infrastructure.dto.AsignaturaOutputDto;

import java.util.List;

public interface AsignaturaService {
    Asignatura addAsignatura(Asignatura asignatura);

    Asignatura getAsignaturaById(String id);

    List<AsignaturaOutputDto> getAllAsignaturas();

    Asignatura updateAsignatura(Asignatura asignatura);

    String deleteById(String id);
}
