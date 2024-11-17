package com.example.airportentity.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "boarding_passes", schema = "bookings")
public class BoardingPass {

    @Id
    @Column(name = "ticket_no", length = 13,nullable = false)
    private String ticketNo;
    @Column(name = "flight_id",nullable = false)
    private int flightId;

    @Column(name = "boarding_no",nullable = false)
    private int boardingNo;
    @Column(name = "seat_no",nullable = false)
    private String seatNo;

    public BoardingPass(String ticketNo, int flightId, int boardingNo, String seatNo) {
        this.ticketNo = ticketNo;
        this.flightId = flightId;
        this.boardingNo = boardingNo;
        this.seatNo = seatNo;
    }

    public BoardingPass() {
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getBoardingNo() {
        return boardingNo;
    }

    public void setBoardingNo(int boardingNo) {
        this.boardingNo = boardingNo;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }
}