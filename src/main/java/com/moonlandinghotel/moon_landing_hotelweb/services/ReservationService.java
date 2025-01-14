package com.moonlandinghotel.moon_landing_hotelweb.services;


import com.moonlandinghotel.moon_landing_hotelweb.models.EventReservation;
import com.moonlandinghotel.moon_landing_hotelweb.models.Reservation;
import com.moonlandinghotel.moon_landing_hotelweb.models.RoomReservation;
import com.moonlandinghotel.moon_landing_hotelweb.models.User;
import com.moonlandinghotel.moon_landing_hotelweb.repositories.EventReservationRepository;
import com.moonlandinghotel.moon_landing_hotelweb.repositories.ReservationRepository;
import com.moonlandinghotel.moon_landing_hotelweb.repositories.RoomReservationRepository;
import com.moonlandinghotel.moon_landing_hotelweb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private RoomReservationRepository roomReservationRepository;

    @Autowired
    private EventReservationRepository eventReservationRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;


    public RoomReservation createRoomReservation(RoomReservation roomReservation) {
        return roomReservationRepository.save(roomReservation);
    }

    public EventReservation createEventReservation(EventReservation eventReservation) {
        return eventReservationRepository.save(eventReservation);
    }

    public List<Reservation> getReservationsByUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        return reservationRepository.findByUser(userOptional.get());
    }


    public void cancelReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}
