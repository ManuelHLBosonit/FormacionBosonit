package com.block7crud.student.domain;

import com.block7crud.asignatura.domain.Asignatura;
import com.block7crud.persona.domain.Persona;
import com.block7crud.profesor.domain.Profesor;
import com.block7crud.student.infrastructure.dto.StudentOutputDto;
import com.block7crud.student.infrastructure.dto.StudentSimple;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id_student;
    private int num_hours_week;
    private String comments;
    private String branch;


    //Relaciones
    @OneToOne
    @JoinColumn(name = "id_persona", nullable = false, unique = true)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    @ManyToMany
    @JoinTable(
            name = "asignatura_student", // Nombre de la tabla de unión deseado
            joinColumns = @JoinColumn(name = "student_id"), // Columna que hace referencia a Asignatura
            inverseJoinColumns = @JoinColumn(name = "asignatura_id") // Columna que hace referencia a Student
    )
    Set<Asignatura> asignaturas;


    public StudentOutputDto studentToStudentOutputDto(){
        return new StudentOutputDto(
                this.id_student,
                this.num_hours_week,
                this.comments,
                this.branch,
                this.persona.getId_persona(),
                this.persona.getUsuario(),
                this.persona.getPassword(),
                this.persona.getName(),
                this.persona.getSurname(),
                this.persona.getCompany_email(),
                this.persona.getPersonal_email(),
                this.persona.getCity(),
                this.persona.isActive(),
                this.persona.getCreated_date(),
                this.persona.getImagen_url(),
                this.persona.getTermination()
        );
    }

    public StudentSimple studentToStudentSimpleOutputDto(){
        String profesor_id = this.profesor != null ? this.profesor.getId_profesor() : null;
        return new StudentSimple(
                this.id_student,
                this.persona.getId_persona(),
                this.num_hours_week,
                this.comments,
                profesor_id,
                this.branch
        );
    }
}
