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

import java.util.List;

@SpringBootApplication(scanBasePackages = {"com.jac.mvc","test"})
public class MvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(@Qualifier("studentRepositoryImpl") StudentRepository repository){
//		return runner -> createStudent(repository);
//	}

	public void createStudent(StudentRepository repository){
		Student student = Student.builder().firstName("Chris").lastName("Redfield").email("ch.r@Gmail.com").build();
		repository.save(student);
		System.out.println("the student is created");

		List<Student> all = repository.getAll();
		all.forEach(System.out::println);

		System.out.println("find the student by id 12 " + repository.findById( 12L));

		Student student2 = Student.builder().firstName("Margot").lastName("Robbie").email("m.r@Gmail.com").build();
		repository.save(student2);
		List<Student> topStudents = repository.findByLastName("Robbie");
		System.out.println("Margot is here -> " + topStudents.get(0));


		topStudents.get(0).setEmail("OOOO.dddd@gmail.com");
		repository.updateStudent(topStudents.get(0));
		System.out.println("updated Margot is here -> " + topStudents.get(0));

		System.out.println("Delete student ");
		repository.deleteStudentById(13L);
	}
}
