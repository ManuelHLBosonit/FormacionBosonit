package com.block7crud.profesor.infrastructure.controller;

import com.block7crud.profesor.application.ProfesorService;
import com.block7crud.profesor.application.ProfesorServiceImpl;
import com.block7crud.profesor.infrastructure.dto.ProfesorInputDto;
import com.block7crud.profesor.infrastructure.dto.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("profesor")
public class ProfesorController {
    @Autowired
    ProfesorService profesorService;

    @PostMapping
    public ResponseEntity<ProfesorOutputDto> addProfesor(@RequestBody ProfesorInputDto profesorInputDto){
        return ResponseEntity.ok().body(profesorService.addProfesor(profesorInputDto).profesorToProfesorOutput());
    }

    @PostMapping("/estudiante")
    public ResponseEntity<String> addStudentToTeacher(@RequestParam String id_student, @RequestParam String id_profesor){
        profesorService.addStudent(id_student, id_profesor);
        return ResponseEntity.ok().body("Student with id " + id_student + " added successfully to teacher with id " + id_profesor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorOutputDto> getProfesorById(@PathVariable String id){
        return ResponseEntity.ok().body(profesorService.getProfesorById(id).profesorToProfesorOutput());
    }

    @GetMapping()
    public Iterable<ProfesorOutputDto> getAllProfesores(){
        return profesorService.getAllProfesores();
    }

    /*
    @PutMapping()
    public ResponseEntity<ProfesorOutputDto> updateTeacher(@RequestBody ProfesorInputDto teacherInputDto){
        return ResponseEntity.ok().body(profesorService.updateTeacher(teacherInputDto));
    }
     */
}
