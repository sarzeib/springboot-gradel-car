package com.springboot.car.service;

import java.util.List;
import java.util.Optional;

import com.springboot.car.model.Car;

public interface CarService {
	
	public Optional<Car> findById(Integer Id);
	public List<Car> findAllCar();
	public void saveCar(Car car);
	public void udpateCar(Car car);
	public void deleteCarById(Integer id);

}
