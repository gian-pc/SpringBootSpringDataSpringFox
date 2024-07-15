package com.gianpc.restapis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// ComponentScan: El busca controllers, services y repositories para agregarlos al classpath
// EnableAutoConfiguration: Configura automaticamente la aplicación, por ejemplo encuentra el H2 en el classpath y lo configura
// SpringBootConfiguration: Clase de configuración de Spring Boot
// SpringBootApplication: Anotacion que combina las tres anotaciones anteriores
@SpringBootApplication
public class RestapisApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapisApplication.class, args);
	}

}
