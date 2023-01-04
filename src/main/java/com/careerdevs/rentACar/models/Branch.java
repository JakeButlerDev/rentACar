package com.careerdevs.rentACar.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
//    private Object location;
    @OneToMany(mappedBy = "homeBranch")
    private Set<Customer> customers;
    @OneToMany(mappedBy = "branch")
    private Set<Car> carInventory;

//    public static class location {
//        private String street;
//        private String city;
//        private String state;
//        private String country;
//        private int addressNumber;
//
//        public String getStreet() {
//            return street;
//        }
//
//        public void setStreet(String street) {
//            this.street = street;
//        }
//
//        public String getCity() {
//            return city;
//        }
//
//        public void setCity(String city) {
//            this.city = city;
//        }
//
//        public String getState() {
//            return state;
//        }
//
//        public void setState(String state) {
//            this.state = state;
//        }
//
//        public String getCountry() {
//            return country;
//        }
//
//        public void setCountry(String country) {
//            this.country = country;
//        }
//
//        public int getAddressNumber() {
//            return addressNumber;
//        }
//
//        public void setAddressNumber(int addressNumber) {
//            this.addressNumber = addressNumber;
//        }
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Object getLocation() {
//        return location;
//    }
//
//    public void setLocation(Object location) {
//        this.location = location;
//    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Set<Car> getCarInventory() {
        return carInventory;
    }

    public void setCarInventory(Set<Car> carInventory) {
        this.carInventory = carInventory;
    }

    public Branch() {

    }

    public Branch(Long id, String name /*, Object location*/) {
        this.id = id;
        this.name = name;
//        this.location = location;
    }
}
