package com.training.springdata.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.springdata.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
