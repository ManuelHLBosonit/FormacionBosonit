package com.block7crud.student.domain;

import com.block7crud.persona.infrastructure.dto.PersonaInputDto;
import com.block7crud.persona.infrastructure.dto.PersonaOutputDto;
import com.block7crud.student.infrastructure.dto.StudentInputDto;
import com.block7crud.student.infrastructure.dto.StudentOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    Student studentInputDtoToStudent (StudentInputDto studentInputDto);
    
}
