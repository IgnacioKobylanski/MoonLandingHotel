package com.moonlandinghotel.moon_landing_hotelweb.services;

import com.moonlandinghotel.moon_landing_hotelweb.models.Room;
import com.moonlandinghotel.moon_landing_hotelweb.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import static java.lang.Double.parseDouble;


@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    //todos los cuartos
    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    //cuarto por id
    public Optional<Room> getRoomById(Long id){
        return roomRepository.findById(id);
    }

    //crer o actualizar
    public Room saveRoom(Room room){
        if (room.getName() == null || room.getName().isEmpty()) {
            throw new IllegalArgumentException("Room name can't be null or empty");
        }
        if ( parseDouble(room.getPrice()) < 0) {
            throw new IllegalArgumentException("Price can't be negative");
        }
        return roomRepository.save(room);
    }

    //eliminar
    public void deleteRoomById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("The ID can't be null");
        }
        if (!roomRepository.existsById(id)) {
            throw new RuntimeException("The Room with id:  " + id + " doesn't exist.");
        }
        roomRepository.deleteById(id);
    }
}
