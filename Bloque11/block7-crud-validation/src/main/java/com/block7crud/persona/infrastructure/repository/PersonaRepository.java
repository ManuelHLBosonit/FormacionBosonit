package com.block7crud.persona.infrastructure.repository;

import com.block7crud.persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, String>, PagingAndSortingRepository<Persona, String> {
    List<Persona> findByNameLike(String name);

}
