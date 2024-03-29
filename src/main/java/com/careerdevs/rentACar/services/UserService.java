package com.careerdevs.rentACar.services;

import com.careerdevs.rentACar.models.User;
import com.careerdevs.rentACar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUser(String username) {
        return userRepository.findByUsername(username).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // Once deleteByUsername is completed in repository, replace so user can be returned with this method
    public User deleteUser(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        userRepository.delete(user);

        return user;
    }

    public User findUserByCustomerId(Long customerId) {
        return userRepository.findByCustomerId(customerId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
