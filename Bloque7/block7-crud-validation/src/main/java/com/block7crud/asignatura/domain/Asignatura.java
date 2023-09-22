package com.block7crud.asignatura.domain;

import com.block7crud.student.domain.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.rmi.server.UID;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id_asignatura;
    private String asignatura;
    private String coment;
    private Date initial_date;
    private Date finish_date;

    //Relaciones
    @ManyToMany
    //Para que solo cree una tabla
    @JoinTable(
            name = "asignatura_student", // Nombre de la tabla de unión deseado
            joinColumns = @JoinColumn(name = "asignatura_id"), // Columna que hace referencia a Asignatura
            inverseJoinColumns = @JoinColumn(name = "student_id") // Columna que hace referencia a Student
    )
    Set<Student> students;
}
