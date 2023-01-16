package com.careerdevs.rentACar.services;

import com.careerdevs.rentACar.models.Branch;
import com.careerdevs.rentACar.models.Car;
import com.careerdevs.rentACar.models.CarType;
import com.careerdevs.rentACar.models.Sedan;
import com.careerdevs.rentACar.repositories.SedanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SedanService extends CarService{

    @Autowired
    private SedanRepository sedanRepository;

    @Override
    public Car saveCar(Car car) {
        return sedanRepository.save(car);
    }

    @Override
    public Car findCar(Long carId) {
        return sedanRepository.findById(carId).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Car deleteCar(Long id) {
        Car foundCar = sedanRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        sedanRepository.deleteById(id);

        return foundCar;
    }

    @Override
    public List<Car> findAll() {
        return sedanRepository.findAll();
    }

    @Override
    public Set<Car> getBranchCars(Branch branch) {
        return sedanRepository.findAllByBranch_id(branch.getId());
    }

    @Override
    public Optional<Car> findByCustomerid (Long customerId) {
        return Optional.ofNullable(sedanRepository.findByCustomer_id(customerId).orElseThrow(
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
