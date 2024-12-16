package com.example.AsterTT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.AsterTT.repository")
@EntityScan(basePackages = "com.example.AsterTT.entity")
public class AsterTtApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsterTtApplication.class, args);
	}

}
