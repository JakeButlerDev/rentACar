package com.careerdevs.rentACar.services;

import com.careerdevs.rentACar.models.Branch;
import com.careerdevs.rentACar.repositories.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    public Branch saveBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    public Branch delete(Long id) {
        Branch branch = branchRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        branchRepository.deleteById(id);
        return branch;
    }

    public Branch findBranch(Long branchId) {
        return branchRepository.findById(branchId).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Branch findBranch(String name) {
        return branchRepository.findByName(name).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Branch> findAll() {
        return branchRepository.findAll();
    }
}
