package com.block7crud.profesor.domain;

import com.block7crud.profesor.infrastructure.dto.ProfesorInputDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfesorMapper {
    ProfesorMapper INSTANCE = Mappers.getMapper(ProfesorMapper.class);

    Profesor profesorInputDtoToProfesor (ProfesorInputDto profesorInputDto);
    
}
