package com.rays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.rays.dto")
@ComponentScan("com.rays")
@EnableJpaRepositories("com.rays.dao")
public class DoctorSpringProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(DoctorSpringProjectApplication.class, args);
		System.out.println("Hello Spring");

	}

}
