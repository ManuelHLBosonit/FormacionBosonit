package com.block10dockerizeapp.infrastructure.repository;

import com.block10dockerizeapp.domain.Coche;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CocheRepository extends JpaRepository<Coche, String>{

}
