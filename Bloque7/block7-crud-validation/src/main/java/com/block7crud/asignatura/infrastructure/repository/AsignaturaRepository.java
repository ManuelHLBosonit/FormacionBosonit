package com.block7crud.asignatura.infrastructure.repository;

import com.block7crud.asignatura.domain.Asignatura;
import com.block7crud.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AsignaturaRepository extends JpaRepository<Asignatura, String>, PagingAndSortingRepository<Asignatura, String> {

}
