package com.app.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class SpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(
			StudentRepository repository,
			MongoTemplate mongoTemplate){
		return  args -> {
			Address address = new Address("Australia","Melbourne","3000");
			String email = "asgoutham99@gmail.com";
			Student student = new Student("goutham",
					"swaminathan",
					email,
					Gender.MALE,
					address,
					List.of("Biryani","Thai Green Curry", "Burger", "HSP"),
					BigDecimal.TEN,
					LocalDateTime.now());
//			Student student2 = new Student("abc","sasi","sasimon@gmail.com");

			Query query = new Query();
			query.addCriteria(Criteria.where("email").is(email));

			List<Student> students = mongoTemplate.find(query, Student.class);
//			if(students.size() > 1) {
//				throw new IllegalStateException("found many students with email : "+ email);
//			}

			if (students.isEmpty()) {
				System.out.println("Inserting student "+ student);
				repository.insert(student);
			} else {
				System.out.println(student + " already exists");
			}

		};
	}

}
