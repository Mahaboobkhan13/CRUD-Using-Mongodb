package com.demo.crudmongo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title = "Library Apis"))
public class CrudmongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudmongoApplication.class, args);
	}

}
