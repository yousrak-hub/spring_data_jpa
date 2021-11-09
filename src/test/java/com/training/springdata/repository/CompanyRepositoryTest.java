package com.training.springdata.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.springdata.entities.Company;
import com.training.springdata.entities.ContactPerson;

@SpringBootTest
public class CompanyRepositoryTest {

	@Autowired
	private CompanyRepository companyRepository;

	@Test
	public void testCreate() {
		Company company = new Company();
		company.setAddress("72 Fremont Road Painesville, OH 44077");
		company.setName("New Company");
		company.setContactPerson(new ContactPerson("Adam", "Louis", "907-898-9399"));
		companyRepository.save(company);

	}
}
