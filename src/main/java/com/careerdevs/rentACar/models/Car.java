package com.careerdevs.rentACar.models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("null")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String make;
    private String model;
    private boolean isRented;
    private double currentGas;
    private boolean fullOfGas;

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

    public boolean getFullOfGas() { return (getCurrentGas() == 1); }

    public void setFullOfGas(boolean fullOfGas) {
        this.fullOfGas = (getCurrentGas() == 1.0);
    }

    public Car(Long id, String make, String model, boolean isRented, boolean fullOfGas, double currentGas, Branch branch) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.isRented = isRented;
        this.fullOfGas = fullOfGas;
        this.currentGas = currentGas;
        this.branch = branch;
    }

    public Car() { }
}
