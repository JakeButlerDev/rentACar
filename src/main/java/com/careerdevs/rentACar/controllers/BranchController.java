package com.careerdevs.rentACar.controllers;

import com.careerdevs.rentACar.models.Branch;
import com.careerdevs.rentACar.repositories.BranchRepository;
import com.careerdevs.rentACar.repositories.CarRepository;
import com.careerdevs.rentACar.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchController {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/")
    public ResponseEntity<?> getAllBranches() {
        List<Branch> allBranches = branchRepository.findAll();
        return new ResponseEntity<>(allBranches, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBranchById(@PathVariable Long branchId) {
        Branch branch = branchRepository.findById(branchId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST)
        );
        return new ResponseEntity<>(branch, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> createNewBranch(@RequestBody Branch newBranchData) {
        try {
            Branch newBranch = branchRepository.save(newBranchData);
            return new ResponseEntity<>(newBranch, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }


}
