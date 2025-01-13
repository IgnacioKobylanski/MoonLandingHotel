package com.moonlandinghotel.moon_landing_hotelweb.services;


import com.moonlandinghotel.moon_landing_hotelweb.models.EventReservation;
import com.moonlandinghotel.moon_landing_hotelweb.repositories.EventReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventReservationService {

    private final EventReservationRepository eventReservationRepository;

    @Autowired
    public EventReservationService(EventReservationRepository eventReservationRepository) {
        this.eventReservationRepository = eventReservationRepository;
    }

    public EventReservation createEventReservation(EventReservation eventReservation) {
        return eventReservationRepository.save(eventReservation);
    }

    public List<EventReservation> getAllEventReservations() {
        return eventReservationRepository.findAll();
    }

    public void deleteEventReservation(Long id) {
        eventReservationRepository.deleteById(id);
    }
}
