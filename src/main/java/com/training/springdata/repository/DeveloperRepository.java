package com.training.springdata.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.springdata.entities.Developer;

public interface DeveloperRepository extends CrudRepository<Developer, Integer>{

}
