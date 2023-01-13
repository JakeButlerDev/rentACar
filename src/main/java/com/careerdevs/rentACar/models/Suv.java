package com.careerdevs.rentACar.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("suv")
public class Suv extends Car{

    private double rate = 2.75;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Suv() { }

    public Suv(Long id, String make, String model, double rate, boolean isRented, boolean fullOfGas, double currentGas, Branch branch) {
        super(id, make, model, isRented, fullOfGas, currentGas, branch);
        this.rate = rate;
    }
}
