package com.careerdevs.rentACar.models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String make;
    private String model;
    private double rate;
    private boolean isRented;
    private boolean fullOfGas;
    private double currentGas;
    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    @JsonIncludeProperties("id")
    private Branch branch;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public boolean isFullOfGas() {
        return fullOfGas;
    }

    public void setFullOfGas(boolean fullOfGas) {
        this.fullOfGas = fullOfGas;
    }

    public double getCurrentGas() {
        return currentGas;
    }

    public void setCurrentGas(double currentGas) {
        this.currentGas = currentGas;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Car() {

    }

    public Car(String make, String model, double rate, boolean isRented, boolean fullOfGas, double currentGas) {
        this.make = make;
        this.model = model;
        this.rate = rate;
        this.isRented = isRented;
        this.fullOfGas = fullOfGas;
        this.currentGas = currentGas;
    }
}
