package com.careerdevs.rentACar.models;

import jakarta.persistence.Entity;

@Entity
public class Suv extends Car{

    private double rate = 2.75;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Suv() { }

    public Suv(Long id, String make, String model, double rate, boolean isRented, boolean fullOfGas, double currentGas, Branch branch, CarType type) {
        super(id, make, model, isRented, fullOfGas, currentGas, branch, type);
        this.rate = rate;
    }
}
