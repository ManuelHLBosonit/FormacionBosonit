package com.block6personcontrollers;

import com.block6personcontrollers.model.City;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Block6PersonControllersApplication {

	public static void main(String[] args) {
		SpringApplication.run(Block6PersonControllersApplication.class, args);
	}

	@Bean
	public List<City> generateTowns() {
		System.out.println("Generando");
		List<City> cities = new ArrayList<>();
		cities.add(new City("Ciudad1", 10000));
		cities.add(new City("Ciudad2", 20000));
		return cities;
	}
}
