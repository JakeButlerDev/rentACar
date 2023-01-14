package com.careerdevs.rentACar.services;

import com.careerdevs.rentACar.repositories.SedanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SedanService extends CarService{

    @Autowired
    private SedanRepository sedanRepository;


}
