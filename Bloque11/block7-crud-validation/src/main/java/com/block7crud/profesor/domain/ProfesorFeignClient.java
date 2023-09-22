package com.block7crud.profesor.domain;

import com.block7crud.profesor.infrastructure.dto.ProfesorOutputDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "profesor-service", url = "http://localhost:8081")
public interface ProfesorFeignClient {
    @GetMapping("/profesor/{id}")
    ProfesorOutputDto getProfesor(@PathVariable String id);
}
