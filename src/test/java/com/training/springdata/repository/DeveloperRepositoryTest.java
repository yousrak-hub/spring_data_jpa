package com.training.springdata.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import com.training.springdata.entities.Developer;
import com.training.springdata.entities.Project;

@SpringBootTest
public class DeveloperRepositoryTest {

	@Autowired
	private DeveloperRepository developerRepository;

	@Test
	public void testCreateDeveloper() {
		Developer developer = new Developer("John");
		
		Set<Project> projects = new HashSet<>();
		projects.add(new Project("ecommerce web app"));
		
		developer.setProjects(projects);
		developerRepository.save(developer);
	}
	
	@Test
	@Transactional
	public void testLoadDeveloper() {
		Optional<Developer> optionalDeveloper = developerRepository.findById(1);
		if(optionalDeveloper.isPresent())
		{
			Developer developer=optionalDeveloper.get();
			System.out.println(developer.toString());
			System.out.println(developer.getProjects().toString());
		}
	}
}
