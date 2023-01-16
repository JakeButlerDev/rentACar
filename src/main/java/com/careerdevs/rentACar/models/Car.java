package com.careerdevs.rentACar.models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String make;
    private String model;
    private boolean isRented;
    private double currentGas;
    private boolean fullOfGas = (getCurrentGas() == 1);

    @Convert(converter = CarTypeAttributeConverter.class)
    private CarType carType;

    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    @JsonIncludeProperties("id")
    private Branch branch;

    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    @JsonIncludeProperties( {"id", "carType"} )
    private Customer customer;

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

    public boolean getFullOfGas() { return fullOfGas; }

    public void setFullOfGas(boolean fullOfGas) {
        this.fullOfGas = fullOfGas;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car(Long id, String make, String model, boolean isRented, boolean fullOfGas, double currentGas, Branch branch, CarType carType) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.isRented = isRented;
        this.fullOfGas = fullOfGas;
        this.currentGas = currentGas;
        this.branch = branch;
        this.carType = carType;
    }

    public Car() { }
}
