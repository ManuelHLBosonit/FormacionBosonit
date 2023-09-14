package com.block6personcontrollers.controllers;

import com.block6personcontrollers.model.City;
import com.block6personcontrollers.model.Person;
import com.block6personcontrollers.service.CityService;
import com.block6personcontrollers.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("controller2")
public class Controlador2 {

    PersonService personService;
    CityService cityService;

    public Controlador2(PersonService personService, CityService cityService){
        this.personService = personService;
        this.cityService = cityService;
    }

    //Personas
    @GetMapping("/getPerson")
    public Person getPerson(){
        Person person = personService.person;
        person.setAge(person.getAge() * 2);
        return person;
    }

    //Ciudades
    @GetMapping("/getCiudades")
    public String getCiudades(){
        if(cityService.getTowns().size() == 0) return "No hay ciudades";
        return cityService.getTowns().toString();
    }
}
