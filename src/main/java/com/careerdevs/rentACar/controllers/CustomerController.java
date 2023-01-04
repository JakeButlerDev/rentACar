package com.careerdevs.rentACar.controllers;

import com.careerdevs.rentACar.models.Branch;
import com.careerdevs.rentACar.models.Customer;
import com.careerdevs.rentACar.repositories.BranchRepository;
import com.careerdevs.rentACar.repositories.CustomerRepository;
import com.careerdevs.rentACar.repositories.UserRepository;
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
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BranchRepository branchRepository;

    @GetMapping("/")
    public ResponseEntity<?> getAllCustomers() {
        List<Customer> allCustomers = customerRepository.findAll();

        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Customer> getCustomerByUsername(@PathVariable String username) {
        Customer customer = customerRepository.findByUser_username(username).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST)
        );
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Customer> createNewCustomer(@RequestBody Customer newCustomerData) {
        Customer createdCustomer = customerRepository.save(newCustomerData);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

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
        Customer deletedCustomer = customerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST)
        );
        customerRepository.delete(deletedCustomer);
        return new ResponseEntity<>(deletedCustomer, HttpStatus.OK);
    }

}
