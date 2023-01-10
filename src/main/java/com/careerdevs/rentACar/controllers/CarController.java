package com.careerdevs.rentACar.controllers;

import com.careerdevs.rentACar.models.Branch;
import com.careerdevs.rentACar.models.Car;
import com.careerdevs.rentACar.repositories.BranchRepository;
import com.careerdevs.rentACar.repositories.CarRepository;
import com.careerdevs.rentACar.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/")
    public ResponseEntity<?> getAllCars() {
        List<Car> allCarsInCompany = carRepository.findAll();
        return new ResponseEntity<>(allCarsInCompany, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Car car = carRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST)
        );
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping("/{branchId}")
    public ResponseEntity<?> getCarsByBranchId(@PathVariable Long branchId) {
        Set<Car> allCarsAtBranch = carRepository.findAllByBranch_id(branchId);
        return new ResponseEntity<>(allCarsAtBranch, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> createNewCar(@RequestBody Car newCarData) {
        Car createdCar = carRepository.save(newCarData);
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }

    //TODO: Add a car to a specific branch by car_id
//    @PostMapping("/{branchId}")
//    public ResponseEntity<?> updateCarToBranch(@PathVariable Long branchId) {
//        Optional<Branch> branch = branchRepository.findById(branchId);
        // branch.setCarInventory, but right now branch is an Optional. Maybe can override from JPA default in BranchRepository
//    }
}
