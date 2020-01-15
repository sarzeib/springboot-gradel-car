package com.springboot.car.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.car.bean.SuccessResponse;
import com.springboot.car.enums.CodeMessageEnum;
import com.springboot.car.exception.ResourceNotFoundException;
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
	public Car findById(Integer id) throws ResourceNotFoundException{
		Optional<Car> optCar = carRepo.findById(id);
		Car car = optCar.orElseThrow(()-> new ResourceNotFoundException(CodeMessageEnum.CITIZEN_NOT_FOUND));
		return car;
	}

	@Override
	public List<Car> findAllCar() {
		return (List<Car>) carRepo.findAll();
	}

	@Override
	public SuccessResponse udpateCar(Car car) throws ResourceNotFoundException {
		Optional<Car> optCar = carRepo.findById(car.getId());
		optCar.orElseThrow(()-> new ResourceNotFoundException(CodeMessageEnum.CITIZEN_NOT_FOUND));
		carRepo.save(car);
		return SuccessResponse.builder()
				.code(CodeMessageEnum.UPDATE_SUCCESSFUL.getErrorCode())
				.message(CodeMessageEnum.UPDATE_SUCCESSFUL.getErrorMsg())
				.success(true)
				.build();
		
	}

	@Override
	public SuccessResponse deleteCarById(Integer id)  throws ResourceNotFoundException{
		Optional<Car> optCar = carRepo.findById(id);
		optCar.orElseThrow(()-> new ResourceNotFoundException(CodeMessageEnum.CITIZEN_NOT_FOUND));
		carRepo.deleteById(id);
		return SuccessResponse.builder()
				.code(CodeMessageEnum.DELETE_SUCCESSFUL.getErrorCode())
				.message(CodeMessageEnum.DELETE_SUCCESSFUL.getErrorMsg())
				.success(true)
				.build();
				
	}

	@Override
	public SuccessResponse saveCar(Car car) {
		carRepo.save(car);
		return SuccessResponse.builder()
				.code(CodeMessageEnum.SAVE_SUCCESSFUL.getErrorCode())
				.message(CodeMessageEnum.SAVE_SUCCESSFUL.getErrorMsg())
				.success(true)
				.build();
	}

}
