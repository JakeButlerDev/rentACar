package com.careerdevs.rentACar.controllers;

import com.careerdevs.rentACar.models.User;
import com.careerdevs.rentACar.repositories.CustomerRepository;
import com.careerdevs.rentACar.repositories.UserRepository;
import com.careerdevs.rentACar.services.CustomerService;
import com.careerdevs.rentACar.services.UserService;
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
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers() {
        List<User> allUsers = userService.findAll();

        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User foundUser = userService.findUser(username);

        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?> getUserByCustomerId(@PathVariable Long customerId) {
        User foundUser = userService.findUserByCustomerId(customerId);

        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> createNewUser(@RequestBody User userData) {
        User createdUser = userService.saveUser(userData);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUserByUsername(@PathVariable String username) {
        User user = userService.deleteUser(username);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
