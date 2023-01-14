package com.careerdevs.rentACar.repositories;

import com.careerdevs.rentACar.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@NoRepositoryBean
public interface CarRepository extends JpaRepository<Car, Long> {

    Set<Car> findAllByBranch_id(Long branchId);

    //TODO: Query MySQL for cars with type carType
//    List<Car> findAllByCarType(String carType);

    Optional<Car> findByCustomer_id(Long customerId);
}
