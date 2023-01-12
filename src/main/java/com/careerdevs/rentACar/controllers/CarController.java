package com.careerdevs.rentACar.controllers;

import com.careerdevs.rentACar.models.Branch;
import com.careerdevs.rentACar.models.Sedan;
import com.careerdevs.rentACar.services.BranchService;
import com.careerdevs.rentACar.services.CarService;
import com.careerdevs.rentACar.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;
    @Autowired
    private BranchService branchService;

    @Autowired
    private CustomerService customerService;

    // Will likely get rid of since all cars should be associated with a Branch
    @GetMapping("/")
    public ResponseEntity<List<Sedan>> getAllCars() {
        List<Sedan> allCarsInCompany = carService.findAll();

        return new ResponseEntity<>(allCarsInCompany, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sedan> getById(@PathVariable Long id) {
        Sedan sedan = carService.findCar(id);

        return new ResponseEntity<>(sedan, HttpStatus.OK);
    }

    @GetMapping("branch/{branchId}")
    public ResponseEntity<Set<Sedan>> getCarsByBranchId(@PathVariable Long branchId) {
        Branch branch = branchService.findBranch(branchId);
        Set<Sedan> carsInBranches = carService.getBranchCars(branch);

        return new ResponseEntity<>(carsInBranches, HttpStatus.OK);
    }

    //TODO: Get Car by customerId

    @PostMapping("/")
    public ResponseEntity<Sedan> createNewCar(@RequestBody Sedan newSedanData) {
        Sedan createdSedan = carService.saveCar(newSedanData);

        return new ResponseEntity<>(createdSedan, HttpStatus.CREATED);
    }

    @PostMapping("branch/{branchId}")
    public ResponseEntity<Sedan> updateCarToBranch(@RequestBody Sedan newSedanData, @PathVariable Long branchId) {
        Branch branch = branchService.findBranch(branchId);
        newSedanData.setBranch(branch);

        return new ResponseEntity<>(carService.saveCar(newSedanData), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Sedan> deleteCarById(@PathVariable Long carId) {
        Sedan sedan = carService.deleteCar(carId);

        return new ResponseEntity<>(sedan, HttpStatus.OK);
    }
}
