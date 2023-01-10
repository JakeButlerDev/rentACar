package com.careerdevs.rentACar.controllers;

import com.careerdevs.rentACar.models.User;
import com.careerdevs.rentACar.repositories.CustomerRepository;
import com.careerdevs.rentACar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers() {
        try {
            List<User> allUsers = userRepository.findAll();
            return new ResponseEntity<>(allUsers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
        Optional<User> foundUser = userRepository.findByUsername(username);
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> createNewUser(@RequestBody User userData) {
        try {
            User createdUser = userRepository.save(userData);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    //TODO: Get User by customerId

}
