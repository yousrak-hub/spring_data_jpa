package com.training.springdata.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.training.springdata.entities.Student;

@SpringBootTest
public class StudentRepositoryTest {
	@Autowired
	StudentRepository studentRepository;

	@Test
	public void testCreate() {
		studentRepository.save(new Student("Linda", "Simon", 11));
	}

	@Test
	public void testFindAllStudents() {
		System.out.println(studentRepository.findAllStudents());
	}

	@Test
	public void testFindAllStudentsPartialData() {
		List<Object[]> partialData = studentRepository.findAllStudentsPartialData();
		for (Object[] objects : partialData) {
			System.out.println(objects[0] + " : " + objects[1]);
		}
	}

	@Test
	public void testFindAllStudentsByFirstName() {
		System.out.println(studentRepository.findAllStudentsByFirstName("Yousra"));
	}

	@Test
	public void testFindStudentsByScores() {
		System.out.println(studentRepository.findStudentsForGivenScores(14, 19));
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testDeleteByFirstName() {
		studentRepository.deleteStudentsByFirstName("Yousra");
	}

}
