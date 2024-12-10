package com.moonlandinghotel.moon_landing_hotelweb.repositories;

import com.moonlandinghotel.moon_landing_hotelweb.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
