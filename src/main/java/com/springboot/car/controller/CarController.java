package com.springboot.car.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.car.exception.ResourceNotFoundException;
import com.springboot.car.model.Car;
import com.springboot.car.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
	
	private CarService carService;
	
	@Autowired
	public CarController(CarService carService) {
		this.carService = carService;
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Optional<Car>> findCarById(@PathVariable Integer id) throws ResourceNotFoundException {
		Optional<Car> car = carService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(car);
	}
	
	@PostMapping(value="/save")
	public ResponseEntity<String> saveCarInfo(@RequestBody Car car){
		carService.saveCar(car);
		return ResponseEntity.status(HttpStatus.OK).body("Car information saved successfully!");
	}
	
	@PutMapping(value="/update")
	public ResponseEntity<String> updateCarInfo(@RequestBody Car car){
		carService.saveCar(car);
		return ResponseEntity.status(HttpStatus.OK).body("Car information updated successfully!");
	}
	
	@GetMapping(value="/cars")
	public ResponseEntity<List<Car>> getAllCarsInfo(){
		return ResponseEntity.status(HttpStatus.OK).body(carService.findAllCar());
	}
	
	@DeleteMapping(value="/cars/{id}")
	public ResponseEntity<String> deleteCarById(@PathVariable Integer id){
		carService.deleteCarById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Car Deleted Successfully!");
	}
}
