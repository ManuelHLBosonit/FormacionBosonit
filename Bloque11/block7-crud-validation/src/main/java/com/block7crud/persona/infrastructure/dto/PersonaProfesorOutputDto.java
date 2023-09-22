package com.block7crud.persona.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaProfesorOutputDto {

    String id_persona;
    String usuario;
    String password;
    String name;
    String surname;
    String company_email;
    String personal_email;
    String city;
    boolean activate;
    Date created_date;
    String imagen_url;
    Date termination_date;
    String id_profesor;
    String comments;
    String branch;
}