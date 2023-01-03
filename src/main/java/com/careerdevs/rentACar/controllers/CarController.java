package com.careerdevs.rentACar.controllers;

import com.careerdevs.rentACar.models.Car;
import com.careerdevs.rentACar.repositories.BranchRepository;
import com.careerdevs.rentACar.repositories.CarRepository;
import com.careerdevs.rentACar.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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

    @GetMapping("/{branchId}")
    public ResponseEntity<?> getCarsByBranchId(@PathVariable Long branchId) {
        Set<Car> allCarsAtBranch = carRepository.findAllByBranch_id(branchId);
        return new ResponseEntity<>(allCarsAtBranch, HttpStatus.OK);
    }
}
