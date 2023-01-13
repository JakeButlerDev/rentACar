package com.careerdevs.rentACar.models;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("sedan")
public class Sedan extends Car {


    private double rate = 1.50;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Sedan() { }

    public Sedan(Long id, String make, String model, double rate, boolean isRented, boolean fullOfGas, double currentGas, Branch branch) {
        super(id, make, model, isRented, fullOfGas, currentGas, branch);
        this.rate = rate;
    }
}