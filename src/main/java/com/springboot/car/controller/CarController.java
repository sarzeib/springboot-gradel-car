package com.springboot.car.controller;

import java.util.List;

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

import com.springboot.car.bean.SuccessResponse;
import com.springboot.car.exception.ResourceNotFoundException;
import com.springboot.car.model.Car;
import com.springboot.car.service.CarService;

@RestController
@RequestMapping("/carapp")
public class CarController {

	private CarService carService;

	@Autowired
	public CarController(CarService carService) {
		this.carService = carService;
	}

	@GetMapping(value = "cars/{id}")
	public ResponseEntity<Car> findCarById(@PathVariable Integer id) throws ResourceNotFoundException {
		Car car = carService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(car);
	}

	@GetMapping(value = "/cars")
	public ResponseEntity<List<Car>> getAllCarsInfo() {
		return ResponseEntity.status(HttpStatus.OK).body(carService.findAllCar());
	}

	@PostMapping(value = "/cars")
	public ResponseEntity<SuccessResponse> saveCarInfo(@RequestBody Car car) {
		SuccessResponse response = carService.saveCar(car);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PutMapping(value = "/cars")
	public ResponseEntity<SuccessResponse> updateCarInfo(@RequestBody Car car) {
		SuccessResponse response = carService.saveCar(car);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@DeleteMapping(value = "/cars/{id}")
	public ResponseEntity<SuccessResponse> deleteCarById(@PathVariable Integer id) throws ResourceNotFoundException {
		SuccessResponse response = carService.deleteCarById(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
