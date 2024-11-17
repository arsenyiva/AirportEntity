package com.example.airportentity.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Check;

@Entity
@Table(name = "aircrafts", schema = "bookings")
@Check(constraints = "range > 0")
public class Aircraft {

    @Id
    @Column(name = "aircraft_code")
    private String aircraftCode;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private int range;

    public String getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(String aircraftCode) {
        this.aircraftCode = aircraftCode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public Aircraft(String aircraftCode, String model, int range) {
        this.aircraftCode = aircraftCode;
        this.model = model;
        this.range = range;
    }

    public Aircraft() {
    }
}

