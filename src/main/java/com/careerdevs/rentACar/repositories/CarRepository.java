package com.careerdevs.rentACar.repositories;

import com.careerdevs.rentACar.models.Car;
import com.careerdevs.rentACar.models.Sedan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CarRepository extends JpaRepository<Car, Long> {

    Set<Car> findAllByBranch_id(Long branchId);
}
