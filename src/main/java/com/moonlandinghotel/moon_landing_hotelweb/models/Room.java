package com.moonlandinghotel.moon_landing_hotelweb.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Entity
@NoArgsConstructor // Constructor sin argumentos (necesario para JPA)
@AllArgsConstructor // Constructor con todos los atributos
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String price;

    // Constructor personalizado (sin ID, ya que lo genera automáticamente)
    public Room(String name, String price) {
        this.name = name;
        this.price = price;
    }
}
