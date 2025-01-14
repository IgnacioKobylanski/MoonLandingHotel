package com.moonlandinghotel.moon_landing_hotelweb.controllers;


import com.moonlandinghotel.moon_landing_hotelweb.models.EventReservation;
import com.moonlandinghotel.moon_landing_hotelweb.models.Reservation;
import com.moonlandinghotel.moon_landing_hotelweb.models.RoomReservation;
import com.moonlandinghotel.moon_landing_hotelweb.repositories.ReservationRepository;
import com.moonlandinghotel.moon_landing_hotelweb.repositories.UserRepository;
import com.moonlandinghotel.moon_landing_hotelweb.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/room")
    public ResponseEntity<RoomReservation> createRoomReservation(@RequestBody RoomReservation roomReservation) {
        RoomReservation savedReservation = reservationService.createRoomReservation(roomReservation);
        return ResponseEntity.ok(savedReservation);
    }

    @PostMapping("/event")
    public ResponseEntity<EventReservation> createEventReservation(@RequestBody EventReservation eventReservation) {
        EventReservation savedReservation = reservationService.createEventReservation(eventReservation);
        return ResponseEntity.ok(savedReservation);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Reservation>> getReservationsByUser(@PathVariable Long userId) {
        List<Reservation> reservations = reservationService.getReservationsByUser(userId);
        if (reservations != null) {
            return ResponseEntity.ok(reservations);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<Void> cancelReservation(@PathVariable Long reservationId) {
        reservationService.cancelReservation(reservationId);
        return ResponseEntity.noContent().build();
    }
}
