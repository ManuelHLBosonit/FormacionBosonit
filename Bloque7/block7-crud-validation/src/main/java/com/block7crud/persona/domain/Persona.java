package com.block7crud.persona.domain;

import com.block7crud.persona.infrastructure.dto.PersonaOutputDto;
import com.block7crud.persona.infrastructure.dto.PersonaProfesorOutputDto;
import com.block7crud.persona.infrastructure.dto.PersonaStudentOutputDto;
import com.block7crud.profesor.domain.Profesor;
import com.block7crud.student.domain.Student;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "personas")

public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_persona")
    private String id_persona;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private boolean active;
    private Date created_date;
    private String  imagen_url;
    private Date termination;

    //Relaciones
    @OneToOne
    private Student student;

    @OneToOne
    private Profesor profesor;


    public PersonaStudentOutputDto personaStudentOutputDto(){
        return new PersonaStudentOutputDto(
                this.id_persona,
                this.usuario,
                this.password,
                this.name,
                this.surname,
                this.company_email,
                this.personal_email,
                this.city,
                this.active,
                this.created_date,
                this.imagen_url,
                this.termination,
                this.student.getId_student(),
                this.student.getNum_hours_week(),
                this.student.getComments(),
                this.student.getBranch()
        );
    }

        public PersonaProfesorOutputDto personaProfesorOutputDto(){
        return new PersonaProfesorOutputDto(
                this.id_persona,
                this.usuario,
                this.password,
                this.name,
                this.surname,
                this.company_email,
                this.personal_email,
                this.city,
                this.active,
                this.created_date,
                this.imagen_url,
                this.termination,
                this.profesor.getId_profesor(),
                this.profesor.getComments(),
                this.profesor.getBranch()
        );
    }
}
