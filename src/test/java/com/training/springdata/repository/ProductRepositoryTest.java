package com.training.springdata.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.springdata.entities.Product;

@SpringBootTest
public class ProductRepositoryTest {
	@Autowired
	ProductRepository productRepository;

	@Test
	public void testCreate() {
		productRepository.save(new Product("iPhone", "Smartphone", 1300d));
	}

	@Test
	public void testRead() {
		Optional<Product> product = productRepository.findById(1);
		if (product.isPresent()) {
			System.out.println("The product is present");
		}
	}

	@Test
	public void testUpdate() {
		Optional<Product> optionalProduct = productRepository.findById(1);
		if (optionalProduct.isPresent()) {
			Product product = optionalProduct.get();
			product.setPrice(2300d);
			productRepository.save(product);
		}
	}

	@Test
	public void testDelete() {
		if (productRepository.existsById(2)) {
			productRepository.deleteById(2);
		}

	}

	@Test
	public void testCount() {
		System.out.println(productRepository.count());

	}
}
