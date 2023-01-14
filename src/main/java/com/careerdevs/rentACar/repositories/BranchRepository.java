package com.careerdevs.rentACar.repositories;

import com.careerdevs.rentACar.models.Branch;
import com.careerdevs.rentACar.models.Car;
import com.careerdevs.rentACar.models.CarType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    Optional<Branch> findByName(String name);

    //TODO: Query database for all cars of a given type
//    @Query
//    Set<Car> findCarsByType(CarType carType);
}
