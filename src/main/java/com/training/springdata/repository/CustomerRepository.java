package com.training.springdata.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.springdata.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
