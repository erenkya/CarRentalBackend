package com.eren.CarRental.service;

import com.eren.CarRental.model.Car;
import com.eren.CarRental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public ResponseEntity<List<Car>> getAllCars() {
        return new ResponseEntity<>(carRepository.findAll(), HttpStatus.OK);
    }
}
