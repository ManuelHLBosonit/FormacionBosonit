package com.block7crud.persona.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaOutputDto {
    int id;
    String nombre;
    int edad;
    String poblacion;
}
