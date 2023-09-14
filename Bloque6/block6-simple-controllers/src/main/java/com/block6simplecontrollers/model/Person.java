package com.block6simplecontrollers.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Entity
//@Data //Generar los getter y setter
@NoArgsConstructor //Constructor sin argumentos
@AllArgsConstructor //Constructor con argumentos
public class Person {

    private String name;
    private String city;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}