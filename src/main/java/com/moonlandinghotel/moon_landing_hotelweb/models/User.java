package com.moonlandinghotel.moon_landing_hotelweb.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
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

}
