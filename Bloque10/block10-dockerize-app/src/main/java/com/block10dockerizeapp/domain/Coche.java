package com.block10dockerizeapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coche {
    @Id
    private String matricula;
    private int kilometros;
    private String nombrePropietario;
    private String marca;
    private String modelo;
}
