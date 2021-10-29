package com.training.springdata.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hibernate.criterion.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.training.springdata.entities.Product;

@SpringBootTest
public class ProductRepositoryTest {
	@Autowired
	ProductRepository productRepository;

	@Test
	public void testCreate() {
		productRepository.save(new Product("S20", "Smartphone", 6000d));
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

	@Test
	public void testFindByName() {
		List<Product> products = productRepository.findByName("iPhone");
		products.forEach(p -> System.out.println(p.getId() + " " + p.getPrice()));

	}

	@Test
	public void testFindByNameAndDescription() {
		List<Product> products = productRepository.findByNameAndDescription("iPhone", "Smartphone");
		products.forEach(p -> System.out.println(p.getId() + " " + p.getPrice()));

	}

	@Test
	public void testFindByPriceGreaterThan() {
		List<Product> products = productRepository.findByPriceGreaterThan(1000d);
		products.forEach(p -> System.out.println(p.getId() + " " + p.getPrice()));

	}

	@Test
	public void testFindByDescriptionContains() {
		List<Product> products = productRepository.findByDescriptionContains("Smartphone");
		products.forEach(p -> System.out.println(p.getId() + " " + p.getPrice()));

	}

	@Test
	public void testFindByPriceBetween() {
		// List<Product> products = productRepository.findByPriceBetween(1000d, 1200d);
		List<Product> products = productRepository.findByPriceBetween(1000d, 2400d);
		products.forEach(p -> System.out.println(p.getId() + " " + p.getPrice()));

	}

	@Test
	public void testFindByDescriptionLike() {
		List<Product> products = productRepository.findByDescriptionLike("%s%");
		products.forEach(p -> System.out.println(p.getId() + " " + p.getPrice()));

	}

	@Test
	public void testFindByIdIn() {
		List<Product> products = productRepository.findByIdIn(Arrays.asList(1, 2, 3));
		products.forEach(p -> System.out.println(p.getId() + " " + p.getPrice()));

	}

	@Test
	public void testFindAllPaging() {
		Page<Product> results = productRepository.findAll(PageRequest.of(0, 5));
		results.forEach(p -> System.out.println(p.getId() + " " + p.getName()));

	}

	@Test
	public void testFindAllSorting() {
		Iterable<Product> results = productRepository.findAll(Sort.by(Direction.DESC, "name", "price"));
		Iterable<Product> sortByMultipleOrders = productRepository
				.findAll(Sort.by(new Sort.Order(Direction.DESC, "name"), new Sort.Order(Direction.ASC, "price")));
//		results.forEach(p -> System.out.println(p.getId() + " " + p.getName() + " " + p.getDesc()));
		sortByMultipleOrders.forEach(p -> System.out.println(p.getId() + " " + p.getName() + " " + p.getDesc()));

	}

	@Test
	public void testFindAllPagingAndSorting() {
		Iterable<Product> results = productRepository.findAll(PageRequest.of(0, 2, Direction.DESC, "name"));
		results.forEach(p -> System.out.println(p.getId() + " " + p.getName() + " " + p.getDesc()));

	}

	@Test
	public void testFindByIdInPaging() {
		List<Product> products = productRepository.findByIdIn(Arrays.asList(1, 2, 3), PageRequest.of(0, 2));
		products.forEach(p -> System.out.println(p.getId() + " " + p.getPrice()));

	}
}
