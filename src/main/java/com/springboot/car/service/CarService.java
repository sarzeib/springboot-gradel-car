package com.springboot.car.service;

import java.util.List;

import com.springboot.car.bean.SuccessResponse;
import com.springboot.car.exception.ResourceNotFoundException;
import com.springboot.car.model.Car;

public interface CarService {
	
	public Car findById(Integer Id) throws ResourceNotFoundException;
	public List<Car> findAllCar();
	public SuccessResponse saveCar(Car car);
	public SuccessResponse udpateCar(Car car) throws ResourceNotFoundException;
	public SuccessResponse deleteCarById(Integer id) throws ResourceNotFoundException;

}
