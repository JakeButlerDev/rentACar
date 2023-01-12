package com.careerdevs.rentACar.models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;

@MappedSuperclass
public abstract class AbstractCarType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String make;
    private String model;
    private boolean isRented;
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

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
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

    public AbstractCarType(Long id, String make, String model, boolean isRented, double currentGas, Branch branch) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.isRented = isRented;
        this.currentGas = currentGas;
        this.branch = branch;
    }

    public AbstractCarType() { }
}
