package com.ratings.wsalternativecourseschool;

import com.ratings.wsalternativecourseschool.model.Course;
import com.ratings.wsalternativecourseschool.model.Student;
import com.ratings.wsalternativecourseschool.repository.CourseRepository;
import com.ratings.wsalternativecourseschool.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WsAlternativeCourseSchoolApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CourseRepository courseRepository;

	public static void main(String[] args) {

		SpringApplication.run(WsAlternativeCourseSchoolApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Student student = new Student();
		student.setName("Richard");
		student.setSurname("Andrew");
		student.setSecondSurname("Beckham");
		student.setActive(1);
		studentRepository.save(student);

		Course math = new Course();
		math.setName("Matemáticas");
		math.setActive(1);
		Course programming = new Course();
		programming.setName("Programación");
		programming.setActive(1);
		Course softwareEngineering = new Course();
		softwareEngineering.setName("Ingeniería de software");
		softwareEngineering.setActive(1);
		courseRepository.save(math);
		courseRepository.save(programming);
		courseRepository.save(softwareEngineering);*/
	}
}
