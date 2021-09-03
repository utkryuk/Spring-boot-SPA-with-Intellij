package com.utkarsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class PhonebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhonebookApplication.class, args);
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Phonebook API",
				"API Documentation for Phonebook API",
				"1.0",
				"Copyright - Utkarsh Gupta",
				new Contact("Utkarsh Gupta", "https://github.com/utkryuk", "utkryuk@gmail.com"),
				"API License",
				"https://github.com/utkryuk/Spring-boot-SPA-with-Intellij",
				Collections.emptyList()
		);
	}

	@Bean
	public Docket swaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/phonebook/**"))
				.apis(RequestHandlerSelectors.basePackage("com.utkarsh"))
				.build()
				.apiInfo(apiDetails());
	}
}
