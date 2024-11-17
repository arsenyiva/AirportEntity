package com.example.airportentity.entity;

import com.example.airportentity.entity.Ticket;
import jakarta.persistence.*;


@Entity
@Table(name = "ticket_flights", schema = "bookings")
public class TicketFlight {

    @Id
    @ManyToOne
    @JoinColumn(name = "ticket_no", referencedColumnName = "ticket_no")
    private Ticket ticket;

    @Id
    @Column(name = "flight_id")
    private int flightId;
    @Column(name = "fare_conditions")
    private String fareConditions;

    private double amount;

    public TicketFlight(Ticket ticket, int flightId, String fareConditions, double amount) {
        this.ticket = ticket;
        this.flightId = flightId;
        this.fareConditions = fareConditions;
        this.amount = amount;
    }

    public TicketFlight() {
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFareConditions() {
        return fareConditions;
    }

    public void setFareConditions(String fareConditions) {
        this.fareConditions = fareConditions;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}