package com.moonlandinghotel.moon_landing_hotelweb.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String text;
    private double price;
    private int dateD;
    private String dateM;
    private String img;


    public Event(String name, String description, String text, double price, int dateD, String dateM, String img) {
        this.name = name;
        this.description = description;
        this.text = text;
        this.price = price;
        this.dateD = dateD;
        this.dateM = dateM;
        this.img = img;
    }
}
