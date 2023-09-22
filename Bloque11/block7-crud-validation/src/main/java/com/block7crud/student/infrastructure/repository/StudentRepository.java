package com.block7crud.student.infrastructure.repository;

import com.block7crud.persona.domain.Persona;
import com.block7crud.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String>, PagingAndSortingRepository<Student, String> {

}
