package com.training.springdata.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.training.springdata.entities.Customer;
import com.training.springdata.entities.PhoneNumber;

@SpringBootTest
public class CustomerRepositoryTest {

	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setName("Louis");

		/*
		 * HashSet<PhoneNumber> numbers = new HashSet<>(); numbers.add(new
		 * PhoneNumber("123456789", customer)); numbers.add(new PhoneNumber("987654321",
		 * customer)); customer.setNumbers(numbers);
		 */

		customer.addPhoneNumber(new PhoneNumber("12345678900"));
		customer.addPhoneNumber(new PhoneNumber("33123456789"));
		customerRepository.save(customer);
	}

	@Test
	@Transactional
	public void testLoadCustomer() {
		Optional<Customer> optionalCustomer = customerRepository.findById(4L);
		if (optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			System.out.println(customer.getName());
			customer.getNumbers().forEach(number -> System.out.println(number.getNumber()));
		}

	}

	@Test
	public void testDelete() {
		customerRepository.deleteById(1L);
	}
}
