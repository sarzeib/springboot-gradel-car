package com.springboot.car.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.car.model.Car;

public interface CarRepository extends CrudRepository<Car, Integer>{

}
