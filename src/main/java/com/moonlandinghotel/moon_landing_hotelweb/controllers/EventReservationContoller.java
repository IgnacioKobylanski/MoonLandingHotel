package com.moonlandinghotel.moon_landing_hotelweb.controllers;


import com.moonlandinghotel.moon_landing_hotelweb.models.EventReservation;
import com.moonlandinghotel.moon_landing_hotelweb.services.EventReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event-reservations")
public class EventReservationContoller {

    private EventReservationService eventReservationService;

    @Autowired
    public EventReservationContoller(EventReservationService eventReservationService){
        this.eventReservationService = eventReservationService;
    }

    @GetMapping
    public List<EventReservation> getAllEventReservations() {
        return eventReservationService.getAllEventReservations();
    }

    @PostMapping
    public ResponseEntity<EventReservation> createEventReservation(@RequestBody EventReservation eventReservation) {
        EventReservation createdEventReservation = eventReservationService.createEventReservation(eventReservation);
        return new ResponseEntity<>(createdEventReservation, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEventReservation(@PathVariable Long id) {
        eventReservationService.deleteEventReservation(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
