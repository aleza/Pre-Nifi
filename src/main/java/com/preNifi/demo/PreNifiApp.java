package com.preNifi.demo;

import com.preNifi.demo.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PreNifiApp {

	public static void main(String[] args) {
		SpringApplication.run(PreNifiApp.class, args);
		
		EntradaService entradaService = new EntradaService();
		entradaService.comienzo();
	}

}
