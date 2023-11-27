package com.jac.mvc;

import com.jac.mvc.entity.Student;
import com.jac.mvc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.jac.mvc","test"})
public class MvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(@Qualifier("studentRepositoryImpl") StudentRepository repository){
		return runner -> createStudent(repository);
	}

	public void createStudent(StudentRepository repository){
		Student student = Student.builder().firstName("Chris").lastName("Redfield").email("ch.r@Gmail.com").build();
		repository.save(student);
		System.out.println("the student is created");

	}
}
