package com.careerdevs.rentACar.repositories;

import com.careerdevs.rentACar.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUsername(String username);

    Optional<User> findByCustomerId(Long id);

    //TODO: deleteByUsername
}
