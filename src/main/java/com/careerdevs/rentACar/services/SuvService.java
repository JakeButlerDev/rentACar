package com.careerdevs.rentACar.services;

import com.careerdevs.rentACar.models.Branch;
import com.careerdevs.rentACar.models.Car;
import com.careerdevs.rentACar.models.CarType;
import com.careerdevs.rentACar.repositories.SuvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SuvService extends CarService{
    
    @Autowired
    private SuvRepository suvRepository;

    @Override
    public Car saveCar(Car car) {
        return suvRepository.save(car);
    }

    @Override
    public Car findCar(Long carId) {
        return suvRepository.findById(carId).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Car deleteCar(Long id) {
        Car foundCar = suvRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        suvRepository.deleteById(id);

        return foundCar;
    }

    @Override
    public List<Car> findAll() {
        return suvRepository.findAll();
    }

    @Override
    public Set<Car> getBranchCars(Branch branch) {
        return suvRepository.findAllByBranch_id(branch.getId());
    }

    @Override
    public Optional<Car> findByCustomerid (Long customerId) {
        return Optional.ofNullable(suvRepository.findByCustomer_id(customerId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        ));
    }

    @Override
    public CarType setCarType(String carType) {
        CarType type = null;
        switch (carType.toLowerCase()) {
            case "sedan" -> type = CarType.SEDAN;
            case "suv" -> type = CarType.SUV;
            case "truck" -> type = CarType.TRUCK;
        }
        return type;
    }
}
