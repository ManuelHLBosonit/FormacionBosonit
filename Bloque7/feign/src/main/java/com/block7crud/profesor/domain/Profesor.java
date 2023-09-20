package com.block7crud.profesor.domain;


import com.block7crud.persona.domain.Persona;
import com.block7crud.profesor.infrastructure.dto.ProfesorOutputDto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id_profesor;
    private String comments;
    private String branch;


    //Relaciones
    @OneToOne
    @JoinColumn(name = "id_persona", nullable = false, unique = true)
    private Persona persona;


    public ProfesorOutputDto profesorToProfesorOutput(){
        return new ProfesorOutputDto(
                this.id_profesor,
                this.persona.getId_persona(),
                this.comments,
                this.branch
        );
    }
}
