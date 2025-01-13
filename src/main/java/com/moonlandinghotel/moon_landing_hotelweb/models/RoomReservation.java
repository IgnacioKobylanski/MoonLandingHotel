package com.moonlandinghotel.moon_landing_hotelweb.models;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RoomReservation extends Reservation {
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

}
