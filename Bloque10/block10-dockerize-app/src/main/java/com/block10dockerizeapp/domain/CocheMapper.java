package com.block10dockerizeapp.domain;

import com.block10dockerizeapp.infrastructure.dto.CocheInputDto;
import com.block10dockerizeapp.infrastructure.dto.CocheOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CocheMapper {

    CocheMapper INSTANCE = Mappers.getMapper(CocheMapper.class);

    Coche cocheInputDtoToCoche (CocheInputDto cocheInputDto);

    CocheOutputDto CocheToCocheOutputDto (Coche coche);
}
