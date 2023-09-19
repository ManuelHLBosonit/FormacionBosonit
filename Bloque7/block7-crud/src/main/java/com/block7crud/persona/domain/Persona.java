package com.block7crud.persona.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    @Id
    @GeneratedValue
    private int id;

    private String nombre;
    private int edad;
    private String poblacion;
}
