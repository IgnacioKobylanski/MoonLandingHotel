package com.moonlandinghotel.moon_landing_hotelweb.models;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EventReservation extends Reservation {
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
