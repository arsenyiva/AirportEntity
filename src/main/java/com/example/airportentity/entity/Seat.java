package com.example.airportentity.entity;

import com.example.airportentity.entity.Aircraft;
import jakarta.persistence.*;


@Entity
@Table(name = "seats", schema = "bookings")
public class Seat {

    @Id
    @ManyToOne
    @JoinColumn(name = "aircraft_code", referencedColumnName = "aircraft_code")
    private Aircraft aircraft;

    @Id
    @Column(name = "seat_no", nullable = false, length = 4)
    private String seatNo;
    @Column(name = "fare_conditions", nullable = false, length = 10)
    private String fareConditions;

    public Seat(Aircraft aircraft, String seatNo, String fareConditions) {
        this.aircraft = aircraft;
        this.seatNo = seatNo;
        this.fareConditions = fareConditions;
    }

    public Seat() {
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public String getFareConditions() {
        return fareConditions;
    }

    public void setFareConditions(String fareConditions) {
        this.fareConditions = fareConditions;
    }
}