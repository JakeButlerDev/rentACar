package com.careerdevs.rentACar.controllers;

import com.careerdevs.rentACar.models.Branch;
import com.careerdevs.rentACar.models.Car;
import com.careerdevs.rentACar.models.CarType;
import com.careerdevs.rentACar.models.Sedan;
import com.careerdevs.rentACar.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;
    @Autowired
    private TruckService truckService;
    @Autowired
    private SedanService sedanService;
    @Autowired
    private SuvService suvService;

    @Autowired
    private BranchService branchService;

    // Will likely get rid of since all cars should be associated with a Branch
    @GetMapping("/")
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> allCarsInCompany = carService.findAll();

        return new ResponseEntity<>(allCarsInCompany, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getById(@PathVariable Long id) {
        Car sedan = carService.findCar(id);

        return new ResponseEntity<>(sedan, HttpStatus.OK);
    }

    @GetMapping("branch/{branchId}")
    public ResponseEntity<Set<Car>> getCarsByBranchId(@PathVariable Long branchId) {
        Branch branch = branchService.findBranch(branchId);
        Set<Car> carsInBranches = carService.getBranchCars(branch);

        return new ResponseEntity<>(carsInBranches, HttpStatus.OK);
    }

    @GetMapping("/style/{carType}")
    public ResponseEntity<List<Car>> getAllCarsByType (@PathVariable String carType) {

        switch (carType.toLowerCase()) {
            case "sedan":
                List<Car> allSedans = sedanService.findAll();
                return new ResponseEntity<>(allSedans, HttpStatus.OK);

            case "suv":
                List<Car> allSuvs = suvService.findAll();
                return new ResponseEntity<>(allSuvs, HttpStatus.OK);

            case "truck":
                List<Car> allTrucks = truckService.findAll();
                return new ResponseEntity<>(allTrucks, HttpStatus.OK);

            default:
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?> getCarByCustomerId (@PathVariable Long customerId) {
        Optional<Car> car = carService.findByCustomerid(customerId);

        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Car> createNewCar(@RequestBody Car newCarData) {
        //TODO: Set carsubtype at first initialization?
        Car createdCar = carService.saveCar(newCarData);
        switch (newCarData.getCarType()) {
            case SEDAN:
                createdCar.setCarType(newCarData.getCarType());
//                set rate dependent on carType
            case SUV:
                createdCar.setCarType(newCarData.getCarType());
            case TRUCK:
                createdCar.setCarType(newCarData.getCarType());
        }
        carService.saveCar(createdCar);

        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }

    @PostMapping("/{carType}/{id}")
    public ResponseEntity<Car> updateCarTypeById(@RequestBody Car updatedCarData, @PathVariable String carType, @PathVariable Long id) {
        Car car = carService.findCar(id);
        CarType type = carService.setCarType(carType);

        if (car.getCarType() == null) {
            car.setCarType(type);
        }
        carService.saveCar(car);

        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PostMapping("branch/{branchId}")
    public ResponseEntity<Car> updateCarToBranch(@RequestBody Car newCarData, @PathVariable Long branchId) {
        Branch branch = branchService.findBranch(branchId);
        newCarData.setBranch(branch);

        return new ResponseEntity<>(carService.saveCar(newCarData), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Car> deleteCarById(@PathVariable Long carId) {
        Car car = carService.deleteCar(carId);

        return new ResponseEntity<>(car, HttpStatus.OK);
    }
}
