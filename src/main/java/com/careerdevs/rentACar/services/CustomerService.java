package com.careerdevs.rentACar.services;

import com.careerdevs.rentACar.models.Customer;
import com.careerdevs.rentACar.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    // Once deleteById is created in repository, customer can be returned below
    public Customer delete(Long id) {
        Customer customer =  customerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        customerRepository.deleteById(id);

        return customer;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findByUsername(String username) {
        return customerRepository.findByUser_username(username).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

}
