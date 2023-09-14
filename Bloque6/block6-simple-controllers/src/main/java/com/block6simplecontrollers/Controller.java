package com.block6simplecontrollers;

import com.block6simplecontrollers.model.Person;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class Controller {

    @GetMapping("/user/{nombre}")
    public String hola(@PathVariable(required = true) String nombre){
        return "Hola! " + nombre;
    }

    @PostMapping("/useradd")
    public Person useradd(@RequestBody Person person) {
        if (person.getAge() <= 0)return person;
        person.setAge(person.getAge() + 1);
        // Si la edad es válida, devuelve la instancia de Person en el ResponseWrapper
        return person;
    }


}
