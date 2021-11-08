package com.training.springdata.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.springdata.entities.Account;

public interface AccountRepository extends CrudRepository<Account, Long>{

}
