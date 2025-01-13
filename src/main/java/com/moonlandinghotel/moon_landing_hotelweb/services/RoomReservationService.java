package com.moonlandinghotel.moon_landing_hotelweb.services;


import com.moonlandinghotel.moon_landing_hotelweb.models.RoomReservation;
import com.moonlandinghotel.moon_landing_hotelweb.repositories.RoomReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomReservationService {
    private final RoomReservationRepository roomReservationRepository;

    @Autowired
    public RoomReservationService(RoomReservationRepository roomReservationRepository) {
        this.roomReservationRepository = roomReservationRepository;
    }

    public RoomReservation createRoomReservation(RoomReservation roomReservation) {
        return roomReservationRepository.save(roomReservation);
    }

    public List<RoomReservation> getAllRoomReservations() {
        return roomReservationRepository.findAll();
    }

    public void deleteRoomReservation(Long id) {
        roomReservationRepository.deleteById(id);
    }

}
