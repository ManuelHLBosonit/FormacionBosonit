package com.block11uploaddownloadfiles.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileOutputDto {
    private Long id;
    private String fileName;
    private Date uploadDate;
    private String category;
}
