package com.example.airportentity.entity;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "flights", schema = "bookings")
public class Flight {

    @Id
    @Column(name = "flight_id")
    private int flightId;

    @Column(name = "flight_no", length = 6)
    private String flightNo;

    @Column(name = "scheduled_departure")
    private Instant scheduledDeparture;
    @Column(name = "scheduled_arrival")
    private Instant scheduledArrival;

    @ManyToOne
    @JoinColumn(name = "departure_airport", referencedColumnName = "airport_code", columnDefinition = "CHAR(3)",nullable = false)
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport", referencedColumnName = "airport_code", columnDefinition = "CHAR(3)",nullable = false)
    private Airport arrivalAirport;

    private String status;

    @ManyToOne
    @JoinColumn(name = "aircraft_code", referencedColumnName = "aircraft_code")
    private Aircraft aircraft;

    @Column(name = "actual_departure")
    private Instant actualDeparture;
    @Column(name = "actual_arrival")
    private Instant actualArrival;

    public Flight(int flightId, String flightNo, Instant scheduledDeparture, Instant scheduledArrival, Airport departureAirport, Airport arrivalAirport, String status, Aircraft aircraft, Instant actualDeparture, Instant actualArrival) {
        this.flightId = flightId;
        this.flightNo = flightNo;
        this.scheduledDeparture = scheduledDeparture;
        this.scheduledArrival = scheduledArrival;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.status = status;
        this.aircraft = aircraft;
        this.actualDeparture = actualDeparture;
        this.actualArrival = actualArrival;
    }

    public Flight() {
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public Instant getScheduledDeparture() {
        return scheduledDeparture;
    }

    public void setScheduledDeparture(Instant scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    public Instant getScheduledArrival() {
        return scheduledArrival;
    }

    public void setScheduledArrival(Instant scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Instant getActualDeparture() {
        return actualDeparture;
    }

    public void setActualDeparture(Instant actualDeparture) {
        this.actualDeparture = actualDeparture;
    }

    public Instant getActualArrival() {
        return actualArrival;
    }

    public void setActualArrival(Instant actualArrival) {
        this.actualArrival = actualArrival;
    }
}
