package com.careerdevs.rentACar.services;

import com.careerdevs.rentACar.models.Branch;
import com.careerdevs.rentACar.models.Car;
import com.careerdevs.rentACar.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public Car findCar(Long carId) {
        return carRepository.findById(carId).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Car deleteCar(Car car) {
        Car foundCar = carRepository.findById(car.getId()).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        carRepository.delete(foundCar);

        return foundCar;
    }

    public Set<Car> getBranchCars(Branch branch) {
        return carRepository.findAllByBranch_id(branch.getId());
    }
}
