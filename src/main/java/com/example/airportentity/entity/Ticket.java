package com.example.airportentity.entity;
import com.example.airportentity.entity.Booking;
import jakarta.persistence.*;


@Entity
@Table(name = "tickets", schema = "bookings")
public class Ticket {

    @Id
    @Column(name = "ticket_no",length = 13)
    private String ticketNo;

    @ManyToOne
    @JoinColumn(name = "book_ref", referencedColumnName = "book_ref")
    private Booking booking;

    @Column(name = "passenger_id",length = 20)
    private String passengerId;
    @Column(name = "passenger_name")
    private String passengerName;

    @Column(name = "contact_data", columnDefinition = "jsonb")
    private String contactData;

    public Ticket(String ticketNo, Booking booking, String passengerId, String passengerName, String contactData) {
        this.ticketNo = ticketNo;
        this.booking = booking;
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.contactData = contactData;
    }

    public Ticket() {
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getContactData() {
        return contactData;
    }

    public void setContactData(String contactData) {
        this.contactData = contactData;
    }
}
