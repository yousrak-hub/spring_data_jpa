package com.training.springdata.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.springdata.entities.Image;

public interface ImageRepository extends CrudRepository<Image, Integer> {

}
