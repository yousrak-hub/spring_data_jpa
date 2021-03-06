package com.training.springdata.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.training.springdata.entities.Product;
import java.lang.String;
import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
	List<Product> findByName(String name);

	List<Product> findByNameAndDescription(String name, String description);

	List<Product> findByPriceGreaterThan(double price);

	List<Product> findByDescriptionContains(String description);

	List<Product> findByPriceBetween(double price1, double price2);

	List<Product> findByDescriptionLike(String pattern);

	List<Product> findByIdIn(List<Integer> ids);

	List<Product> findByIdIn(List<Integer> ids, Pageable pageable);

}
