package com.training.springdata.repository;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.springdata.entities.License;
import com.training.springdata.entities.Person;

@SpringBootTest
public class LicenseRepositoryTest {

	@Autowired
	private LicenseRepository licenseRepository;

	@Test
	public void testCreate() {

		License license = new License("Car", new Date());
		license.setPerson(new Person("Adam", "Louis", 34));
		licenseRepository.save(license);
	}
}
