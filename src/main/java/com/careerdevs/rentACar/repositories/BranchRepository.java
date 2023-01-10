package com.careerdevs.rentACar.repositories;

import com.careerdevs.rentACar.models.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BranchRepository extends JpaRepository<Branch, Long> {

    Optional<Branch> findByName(String name);
}
