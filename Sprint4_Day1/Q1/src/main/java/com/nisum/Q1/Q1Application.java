package com.nisum.Q1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Q1Application {

	public static void main(String[] args) {
		SpringApplication.run(Q1Application.class, args);
	}

	@Bean
	CommandLineRunner runner(Greeter greeter) {
		return args -> {
			System.out.println(greeter.greet("Spring Boot"));
		};
	}
}
