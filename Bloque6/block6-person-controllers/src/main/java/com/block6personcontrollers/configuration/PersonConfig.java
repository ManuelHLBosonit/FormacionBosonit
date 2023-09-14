package com.block6personcontrollers.configuration;

import com.block6personcontrollers.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfig {
    @Bean
    public Person bean1(){
        return new Person("bean1","Jaen",21);
    }

    @Bean
    public Person bean2(){
        return new Person("bean2","Malaga",22);
    }

    @Bean
    public  Person bean3(){
        return new Person("bean3", "Torres", 34);
    }
}
