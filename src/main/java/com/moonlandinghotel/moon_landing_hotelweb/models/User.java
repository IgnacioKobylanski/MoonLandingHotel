package com.moonlandinghotel.moon_landing_hotelweb.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Entity
@NoArgsConstructor // Constructor sin argumentos (para JPA)
@AllArgsConstructor // Constructor con todos los atributos
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @Column(length = 60)
    private String password;

    private String name;

    private String lastname;

    private boolean admin;

    public User(String email, String password, String name, String lastname, boolean admin) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.admin = admin;
    }

    // Constructor personalizado
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
