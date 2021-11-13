package com.training.springdata.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.springdata.entities.License;

public interface LicenseRepository extends CrudRepository<License, Long>{

}
