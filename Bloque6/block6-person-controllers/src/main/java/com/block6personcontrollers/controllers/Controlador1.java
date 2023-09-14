package com.block6personcontrollers.controllers;

import com.block6personcontrollers.model.City;
import com.block6personcontrollers.model.Person;
import com.block6personcontrollers.service.CityService;
import com.block6personcontrollers.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Map;

@RestController
@RequestMapping("controller1")
public class Controlador1 {

    @Autowired
    PersonService personService;

    @Autowired
    CityService cityService;

    private Person bean1;
    private Person bean2;
    private Person bean3;


    public Controlador1(@Qualifier("bean1") Person bean1,
                        @Qualifier("bean2") Person bean2,
                        @Qualifier("bean3") Person bean3) {
        this.bean1 = bean1;
        this.bean2 = bean2;
        this.bean3 = bean3;
    }

    @GetMapping("/{bean}")
    public Person getBean(@PathVariable String bean) {
        switch (bean) {
            case "bean1":
                return bean1;
            case "bean2":
                return bean2;
            case "bean3":
                return bean3;
        }
        return null;
    }
    @PostMapping("/addPerson")
    public Person addPerson(@RequestHeader Map<String, String> map){
       return personService.newPerson(map.get("name"), map.get("city"), Integer.parseInt(map.get("age")));
    }

    @PostMapping("/addCity")
    public String addCity(@RequestBody City city){
        if (cityService.addCity(city))return "city added successfully";
        return "Error";
    }
}
