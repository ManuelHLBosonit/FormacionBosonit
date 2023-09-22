package com.block7crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Block7CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(Block7CrudApplication.class, args);
	}

}
