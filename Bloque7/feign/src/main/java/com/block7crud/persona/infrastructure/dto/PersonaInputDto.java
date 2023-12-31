package com.block7crud.persona.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaInputDto {
     private String id_persona;
     private String usuario;
     private String password;
     private String name;
     private String surname;
     private String company_email;
     private String personal_email;
     private String city;
     private boolean active;
     private Date created_date;
     private String  imagen_url;
     private Date termination;
}
