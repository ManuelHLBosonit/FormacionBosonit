package com.block7crud.asignatura.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsignaturaOutputDto {
    private String id_asignatura;
    private String asignatura;
    private String coment;
    private Date initial_date;
    private Date finish_date;
}
