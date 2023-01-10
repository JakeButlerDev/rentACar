package com.careerdevs.rentACar.repositories;

import com.careerdevs.rentACar.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByUser_username(String username);

    //TODO: Delete by id so Customer can be returned to service
}
