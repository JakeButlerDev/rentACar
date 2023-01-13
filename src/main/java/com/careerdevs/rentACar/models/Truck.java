package com.careerdevs.rentACar.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("truck")
public class Truck extends Car {

    private double rate = 3.15;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Truck() { }

    public Truck(Long id, String make, String model, double rate, boolean isRented, boolean fullOfGas, double currentGas, Branch branch) {
        super(id, make, model, isRented, fullOfGas, currentGas, branch);
        this.rate = rate;
    }
}
