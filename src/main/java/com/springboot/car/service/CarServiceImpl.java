package com.springboot.car.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.car.model.Car;
import com.springboot.car.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService{

	private CarRepository carRepo;

	@Autowired
	public CarServiceImpl(CarRepository carRepo) {
		this.carRepo = carRepo;
	}

	@Override
	public Optional<Car> findById(Integer id) {
		return carRepo.findById(id);
	}

	@Override
	public List<Car> findAllCar() {
		return (List<Car>) carRepo.findAll();
	}

	@Override
	public void udpateCar(Car car) {
		carRepo.save(car);
	}

	@Override
	public void deleteCarById(Integer id) {
		carRepo.deleteById(id);
	}

	@Override
	public void saveCar(Car car) {
		carRepo.save(car);
	}

}
