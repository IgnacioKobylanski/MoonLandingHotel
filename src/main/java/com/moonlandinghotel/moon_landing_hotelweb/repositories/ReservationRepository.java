package com.moonlandinghotel.moon_landing_hotelweb.repositories;

import com.moonlandinghotel.moon_landing_hotelweb.models.Reservation;
import com.moonlandinghotel.moon_landing_hotelweb.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUser(User user);
}
