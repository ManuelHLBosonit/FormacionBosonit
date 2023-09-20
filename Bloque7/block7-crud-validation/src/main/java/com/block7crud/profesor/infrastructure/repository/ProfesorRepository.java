package com.block7crud.profesor.infrastructure.repository;

import com.block7crud.asignatura.domain.Asignatura;
import com.block7crud.profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, String>, PagingAndSortingRepository<Profesor, String> {

}
