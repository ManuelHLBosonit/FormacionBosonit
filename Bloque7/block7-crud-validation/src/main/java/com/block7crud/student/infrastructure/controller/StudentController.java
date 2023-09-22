package com.block7crud.student.infrastructure.controller;

import com.block7crud.asignatura.infrastructure.dto.AsignaturaOutputDto;
import com.block7crud.persona.application.PersonaServiceImpl;
import com.block7crud.persona.domain.Persona;
import com.block7crud.persona.domain.PersonaMapper;
import com.block7crud.student.application.StudentService;
import com.block7crud.student.application.StudentServiceImpl;
import com.block7crud.student.domain.Student;
import com.block7crud.student.domain.StudentMapper;
import com.block7crud.student.infrastructure.dto.StudentInputDto;
import com.block7crud.student.infrastructure.dto.StudentOutputDto;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;


    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable String id, @RequestParam(defaultValue = "simple") String ouputType) throws Exception {
        if (ouputType.equals("full"))return ResponseEntity.ok().body((studentService.searchById(id)).studentToStudentOutputDto());
        return ResponseEntity.ok().body((studentService.searchById(id)).studentToStudentSimpleOutputDto());
    }

    @GetMapping()
    public Iterable<StudentOutputDto> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping
    public ResponseEntity<StudentOutputDto> addStudent(@RequestBody StudentInputDto student) throws Exception {
        return ResponseEntity.ok().body((studentService.addStudent(student)).studentToStudentOutputDto());
    }

    @PutMapping
    public ResponseEntity<StudentOutputDto> changeStudent(@RequestBody StudentInputDto student) throws Exception {
        return ResponseEntity.ok().body((studentService.modifyStudent(student)).studentToStudentOutputDto());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id){
        String respuesta = studentService.deleteById(id);
        return ResponseEntity.ok().body(respuesta);
    }



    //Asignaturas
    @PostMapping("/asignatura")
    public ResponseEntity<String> addAsignatura(@RequestParam String id_student, @RequestParam String id_asignatura){
        studentService.addStudentToAsignatura(id_student, id_asignatura);
        return ResponseEntity.ok().body("Asignatura con id " + id_asignatura + " añadido con exito al alumno con id " + id_student);
    }

    @PostMapping("/asiAsignaturas/{id}")
    public ResponseEntity<String> asignarAsignaturas(@PathVariable String id, @RequestParam List<String> id_asignaturas){
        studentService.asignarAsignaturasEstudiante(id, id_asignaturas);
        return ResponseEntity.ok().body("Asignaturas creadas correctamente");
    }

    @PostMapping("/desaAsignaturas/{id}")
    public ResponseEntity<String> desasignarAsignaturas(@PathVariable String id, @RequestParam List<String> id_asignaturas){
        studentService.desasignarAsignaturasEstudiante(id, id_asignaturas);
        return ResponseEntity.ok().body("Asignaturas eliminadas correctamente");
    }

    @GetMapping("/estudiante_asignatura/{id}")
    public Iterable<AsignaturaOutputDto> getAsignaturas(@PathVariable String id){
        return studentService.getAsignaturasByStudentId(id);
    }
}
