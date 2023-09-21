package com.block10dockerizeapp.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CocheOutputDto {
    private String matricula;
    private int kilometros;
    private String nombrePropietario;
    private String marca;
    private String modelo;
}
