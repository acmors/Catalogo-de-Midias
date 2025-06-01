package com.catalogo.CatalogoDeMidias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CatalogoDeMidiasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogoDeMidiasApplication.class, args);
	}

}
