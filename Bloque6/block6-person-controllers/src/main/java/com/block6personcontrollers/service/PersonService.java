package com.block6personcontrollers.service;

import com.block6personcontrollers.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    public Person person;
    public Person newPerson(String name, String city, int age){
        return this.person = new Person(name, city, age);
    }
}
