package com.careerdevs.rentACar.controllers;

import com.careerdevs.rentACar.models.Branch;
import com.careerdevs.rentACar.models.Customer;
import com.careerdevs.rentACar.repositories.BranchRepository;
import com.careerdevs.rentACar.repositories.CustomerRepository;
import com.careerdevs.rentACar.repositories.UserRepository;
import com.careerdevs.rentACar.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BranchRepository branchRepository;

    @GetMapping("/")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> allCustomers = customerService.findAll();

        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        Customer requestedCustomer = customerService.findById(customerId);

        return new ResponseEntity<>(requestedCustomer, HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Customer> getCustomerByUsername(@PathVariable String username) {
        Customer customer = customerService.findByUsername(username);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Customer> createNewCustomer(@RequestBody Customer newCustomerData) {
        Customer createdCustomer = customerService.save(newCustomerData);

        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    //TODO: Update customer by id or username


    //TODO: Get all customers by branch id
//    @PostMapping("/{branchId}/")
//    public ResponseEntity<?> createNewCustomer(@RequestBody Customer customerData, Long branchId) {
//        Branch customerBranch = branchRepository.findById(branchId).orElseThrow(
//                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
//        );

//        Customer createdCustomer = customerRepository.save(customerData);
//
//        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable Long id) {
        Customer deletedCustomer = customerService.findById(id);
        customerService.delete(id);

        return new ResponseEntity<>(deletedCustomer, HttpStatus.OK);
    }

}
