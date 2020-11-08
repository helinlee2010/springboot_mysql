package com.example.springboot_mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SpringbootMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMysqlApplication.class, args);
	}

}
