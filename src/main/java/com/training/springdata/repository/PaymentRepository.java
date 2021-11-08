package com.training.springdata.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.springdata.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
