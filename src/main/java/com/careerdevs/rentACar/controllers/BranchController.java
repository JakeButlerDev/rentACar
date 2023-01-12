package com.careerdevs.rentACar.controllers;

import com.careerdevs.rentACar.models.Branch;
import com.careerdevs.rentACar.repositories.BranchRepository;
import com.careerdevs.rentACar.repositories.CarRepository;
import com.careerdevs.rentACar.repositories.CustomerRepository;
import com.careerdevs.rentACar.services.BranchService;
import com.careerdevs.rentACar.services.CarService;
import com.careerdevs.rentACar.services.CustomerService;
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
    private BranchService branchService;

    @Autowired
    private CarService carService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<?> getAllBranches() {
        List<Branch> allBranches = branchService.findAll();
        return new ResponseEntity<>(allBranches, HttpStatus.OK);
    }

    @GetMapping("/{branchId}")
    public ResponseEntity<?> getBranchById(@PathVariable Long branchId) {
        Branch branch = branchService.findBranch(branchId);

        return new ResponseEntity<>(branch, HttpStatus.OK);
    }

    @GetMapping("/name/{branchName}")
    public ResponseEntity<Branch> getBranchByName(@PathVariable String branchName) {
        Branch foundBranch = branchService.findBranch(branchName);

        return new ResponseEntity<>(foundBranch, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> createNewBranch(@RequestBody Branch newBranchData) {
        Branch newBranch = branchService.saveBranch(newBranchData);

        return new ResponseEntity<>(newBranch, HttpStatus.CREATED);
    }

    @PostMapping("/{branchId}")
    public ResponseEntity<?> updateBranchById(@RequestBody Branch updatedData, @PathVariable Long branchId) {
        Branch foundBranch = branchService.findBranch(branchId);

        if (foundBranch.getName().equals("") && updatedData.getName() != null) {
            foundBranch.setName(updatedData.getName());
        }
        //TODO: Also compare List of customers and cars, if updatedData has unincluded values then add to current List

        return new ResponseEntity<>(foundBranch, HttpStatus.OK);
    }

    @DeleteMapping("/{branchId}")
    public ResponseEntity<?> deleteById(@PathVariable Long branchId) {
        Branch branch = branchService.delete(branchId);

        return new ResponseEntity<>(branch, HttpStatus.OK);
    }

}
