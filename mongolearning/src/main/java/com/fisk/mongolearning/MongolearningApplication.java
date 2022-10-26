package com.fisk.mongolearning;

import com.fisk.mongolearning.model.Address;
import com.fisk.mongolearning.model.Gender;
import com.fisk.mongolearning.model.Student;
import com.fisk.mongolearning.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

@SpringBootApplication
public class MongolearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongolearningApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository studentRepository){

		return args -> {
			Student student = new Student(
					"Ayisha",
					"Mohammed",
					"ayisha@gmail.com",
					Gender.FEMALE,
					new Address("United States","Fremont", 94538),
					LocalTime.now(),
					List.of("Math","Science","Java"),
					BigDecimal.TEN

			);
			Student student1 = new Student(
					"Collins",
					"Test",
					"collins@gmail.com",
					Gender.FEMALE,
					new Address("United States","Fremont", 94538),
					LocalTime.now(),
					List.of("Math","Science","Java"),
					BigDecimal.TEN

			);
			studentRepository.save(student1);
		};
	}
}
