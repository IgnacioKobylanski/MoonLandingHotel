package com.moonlandinghotel.moon_landing_hotelweb.repositories;

import com.moonlandinghotel.moon_landing_hotelweb.models.RoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomReservationRepository extends JpaRepository<RoomReservation, Long> {
}
