package com.block7crud.asignatura.domain;

import com.block7crud.asignatura.infrastructure.dto.AsignaturaInputDto;
import com.block7crud.asignatura.infrastructure.dto.AsignaturaOutputDto;
import com.block7crud.persona.domain.Persona;
import com.block7crud.persona.infrastructure.dto.PersonaInputDto;
import com.block7crud.persona.infrastructure.dto.PersonaOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AsignaturaMapper {
    AsignaturaMapper INSTANCE = Mappers.getMapper(AsignaturaMapper.class);

    Asignatura asignaturaInputDtoToAsignatura (AsignaturaInputDto asignaturaInputDto);

    AsignaturaOutputDto AsignaturaToAsignaturaOutputDto (Asignatura asignatura);
}
