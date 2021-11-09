package com.training.springdata.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.springdata.entities.Company;

public interface CompanyRepository extends CrudRepository<Company, Integer>{

}
