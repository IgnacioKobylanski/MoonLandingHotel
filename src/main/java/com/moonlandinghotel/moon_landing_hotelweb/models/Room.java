package com.moonlandinghotel.moon_landing_hotelweb.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String roomNumber;
    private String type;
    private double price;
    private boolean isOccupied;
    private int capacity;

    @OneToMany(mappedBy = "room")
    private Set<Reservation> reservations;
}
