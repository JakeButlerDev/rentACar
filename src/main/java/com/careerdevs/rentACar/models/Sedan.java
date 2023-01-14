package com.careerdevs.rentACar.models;

import jakarta.persistence.*;

@Entity
public class Sedan extends Car {

    private double rate = 1.50;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Sedan() { }

    public Sedan(Long id, String make, String model, double rate, boolean isRented, boolean fullOfGas, double currentGas, Branch branch, CarType type) {
        super(id, make, model, isRented, fullOfGas, currentGas, branch, type);
        this.rate = rate;
    }
}