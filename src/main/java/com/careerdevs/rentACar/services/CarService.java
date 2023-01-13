package com.careerdevs.rentACar.services;

import com.careerdevs.rentACar.models.Branch;
import com.careerdevs.rentACar.models.Car;
import com.careerdevs.rentACar.models.Sedan;
import com.careerdevs.rentACar.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car saveCar(Car sedan) {
        return carRepository.save(sedan);
    }

    public Car findCar(Long carId) {
        return carRepository.findById(carId).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Car deleteCar(Long id) {
        Car foundCar = carRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        carRepository.deleteById(id);

        return foundCar;
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Set<Car> getBranchCars(Branch branch) {
        return carRepository.findAllByBranch_id(branch.getId());
    }
}
