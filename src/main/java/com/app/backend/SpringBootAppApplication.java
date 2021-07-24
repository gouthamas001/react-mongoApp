package com.app.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository){
		return  args -> {
			Student student = new Student("goutham","swaminathan","asgoutham99@gmail.com");
			Student student2 = new Student("abc","sasi","sasimon@gmail.com");
			repository.insert(student);
			repository.insert(student2);
		};
	}

}
