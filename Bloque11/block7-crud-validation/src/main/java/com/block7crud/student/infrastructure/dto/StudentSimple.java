package com.block7crud.student.infrastructure.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentSimple {
    String id_student;
    String id_persona;
    int num_hours_week;
    String comments;
    String id_profesor;
    String branch;
}
