package com.moonlandinghotel.moon_landing_hotelweb.controllers;


import com.moonlandinghotel.moon_landing_hotelweb.models.RoomReservation;
import com.moonlandinghotel.moon_landing_hotelweb.services.RoomReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-reservations")
public class RoomReservationController {
    private final RoomReservationService roomReservationService;

    @Autowired
    public RoomReservationController(RoomReservationService roomReservationService) {
        this.roomReservationService = roomReservationService;
    }

    @GetMapping
    public List<RoomReservation> getAllRoomReservations() {
        return roomReservationService.getAllRoomReservations();
    }

    @PostMapping
    public ResponseEntity<RoomReservation> createRoomReservation(@RequestBody RoomReservation roomReservation) {
        RoomReservation createdRoomReservation = roomReservationService.createRoomReservation(roomReservation);
        return new ResponseEntity<>(createdRoomReservation, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoomReservation(@PathVariable Long id) {
        roomReservationService.deleteRoomReservation(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
