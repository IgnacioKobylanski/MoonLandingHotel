package com.moonlandinghotel.moon_landing_hotelweb.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private String text;

    private double price;

    private int dateD;

    private String dateM;

    private String img;
}
