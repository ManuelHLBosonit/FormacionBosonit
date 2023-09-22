package com.block11uploaddownloadfiles.domain;

import com.block11uploaddownloadfiles.infrastructure.dto.FileInputDto;
import com.block11uploaddownloadfiles.infrastructure.dto.FileOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FileMapper {
    FileMapper INSTANCE = Mappers.getMapper(FileMapper.class);

    FileEntity fileInputDtoToFile (FileInputDto fileInputDto);

    FileOutputDto FileToFileOutputDto (FileEntity fileEntity);
}
