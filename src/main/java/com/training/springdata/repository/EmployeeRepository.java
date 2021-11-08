package com.training.springdata.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.springdata.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
