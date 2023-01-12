package com.careerdevs.rentACar.repositories;

import com.careerdevs.rentACar.models.Sedan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CarRepository extends JpaRepository<Sedan, Long> {

    Set<Sedan> findAllByBranch_id(Long branchId);
}
