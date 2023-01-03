package com.careerdevs.rentACar.controllers;

import com.careerdevs.rentACar.repositories.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/branches")
public class BranchController {

    @Autowired
    private BranchRepository branchRepository;
}
