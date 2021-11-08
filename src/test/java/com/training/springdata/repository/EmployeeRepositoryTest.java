package com.training.springdata.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.springdata.entities.ActiveEmployee;
import com.training.springdata.entities.CreditCard;
import com.training.springdata.entities.RetiredEmployee;

@SpringBootTest
public class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	public void testCreateActiveEmployee() {
		ActiveEmployee activeEmployee = new ActiveEmployee();
		activeEmployee.setE_name("A");
		activeEmployee.setE_salary(5000);
		activeEmployee.setE_experience(20);
		employeeRepository.save(activeEmployee);
	}
	
	@Test
	public void testCreateRetiredEmployee() {
		RetiredEmployee retiredEmployee = new RetiredEmployee();
		retiredEmployee.setE_name("B");
		retiredEmployee.setE_pension(3500);
		employeeRepository.save(retiredEmployee);
	}
}
