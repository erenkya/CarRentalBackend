package com.eren.CarRental.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.ZoneId;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String plateNumber; // e.g 34AB3434
    private String make; // e.g., Toyota, Honda
    private String model; // e.g., Corolla, Civic
    private String color; // e.g., Red, Blue
    private Integer year; // e.g., 2020, 2021
    private boolean isAvailable; // To track if the car is available for rental


    // Default constructor sets the timezone to the system default
    public Car(String plateNumber, String make, String model, String color, Integer year, boolean isAvailable) {
        this.plateNumber = plateNumber;
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.isAvailable = isAvailable;

    }
    public Car() {}

    public Integer getId() {
        return id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public Integer getYear() {
        return year;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
