package com.moonlandinghotel.moon_landing_hotelweb.repositories;

import com.moonlandinghotel.moon_landing_hotelweb.models.EventReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventReservationRepository extends JpaRepository<EventReservation, Long> {
}
