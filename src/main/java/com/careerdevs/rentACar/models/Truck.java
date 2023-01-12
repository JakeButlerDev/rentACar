package com.careerdevs.rentACar.models;

import jakarta.persistence.Entity;

@Entity
public class Truck extends AbstractCarType{

    private double rate = 3.15;

    private boolean fullOfGas;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public boolean isFullOfGas() {
        return (getCurrentGas() == 1.0);
    }

    public void setFullOfGas(boolean fullOfGas) {
        this.fullOfGas = (getCurrentGas() == 1.0);
    }

    public Truck() { }

    public Truck(Long id, String make, String model, double rate, boolean isRented, boolean fullOfGas, double currentGas, Branch branch) {
        super(id, make, model, isRented, currentGas, branch);
        this.rate = rate;
        this.fullOfGas = fullOfGas;
    }
}
