package com.example.airportentity.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "bookings", schema = "bookings")
public class Booking {

    @Id
    @Column(name = "book_ref", length = 6,nullable = false)
    private String bookRef;
    @Column(name = "book_date",nullable = false)
    private Instant bookDate;
    @Column(name = "total_amount",nullable = false)
    private double totalAmount;

    public Booking(String bookRef, Instant bookDate, double totalAmount) {
        this.bookRef = bookRef;
        this.bookDate = bookDate;
        this.totalAmount = totalAmount;
    }

    public Booking() {
    }

    public String getBookRef() {
        return bookRef;
    }

    public void setBookRef(String bookRef) {
        this.bookRef = bookRef;
    }

    public Instant getBookDate() {
        return bookDate;
    }

    public void setBookDate(Instant bookDate) {
        this.bookDate = bookDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}


