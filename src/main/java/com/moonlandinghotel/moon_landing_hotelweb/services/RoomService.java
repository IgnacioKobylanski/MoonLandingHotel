package com.moonlandinghotel.moon_landing_hotelweb.services;

import com.moonlandinghotel.moon_landing_hotelweb.models.Room;
import com.moonlandinghotel.moon_landing_hotelweb.repositories.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private static final Logger logger = LoggerFactory.getLogger(RoomService.class);

    @Autowired
    private RoomRepository roomRepository;

    // Obtener todos los cuartos
    public List<Room> getAllRooms() {
        logger.info("Fetching all rooms");
        List<Room> rooms = roomRepository.findAll();
        logger.info("Found {} rooms", rooms.size());
        return rooms;
    }

    // Obtener cuarto por ID
    public Optional<Room> getRoomById(Long id) {
        logger.info("Fetching room with ID: {}", id);
        if (id == null) {
            logger.error("The ID can't be null");
            throw new IllegalArgumentException("The ID can't be null");
        }
        Optional<Room> room = roomRepository.findById(id);
        if (room.isPresent()) {
            logger.info("Found room: {}", room.get().getName());
        } else {
            logger.warn("Room with ID {} not found", id);
        }
        return room;
    }

    // Crear o actualizar cuarto
    public Room saveRoom(Room room) {
        logger.info("Saving room with name: {}", room.getName());

        if (room.getName() == null || room.getName().isEmpty()) {
            logger.error("Room name can't be null or empty");
            throw new IllegalArgumentException("Room name can't be null or empty");
        }

        if (room.getPrice() < 0) {  // Asegurando que el precio sea un número positivo
            logger.error("Price can't be negative");
            throw new IllegalArgumentException("Price can't be negative");
        }

        // Verificando que la descripción y la URL de la imagen no estén vacías
        if (room.getDescription() == null || room.getDescription().isEmpty()) {
            logger.error("Room description can't be null or empty");
            throw new IllegalArgumentException("Room description can't be null or empty");
        }

        if (room.getImageUrl() == null || room.getImageUrl().isEmpty()) {
            logger.error("Room image URL can't be null or empty");
            throw new IllegalArgumentException("Room image URL can't be null or empty");
        }

        Room savedRoom = roomRepository.save(room);
        logger.info("Room saved with ID: {}", savedRoom.getId());
        return savedRoom;
    }

    // Eliminar cuarto por ID
    public void deleteRoomById(Long id) {
        logger.info("Deleting room with ID: {}", id);

        if (id == null) {
            logger.error("The ID can't be null");
            throw new IllegalArgumentException("The ID can't be null");
        }

        if (!roomRepository.existsById(id)) {
            logger.error("The Room with ID {} doesn't exist.", id);
            throw new RuntimeException("The Room with ID " + id + " doesn't exist.");
        }

        roomRepository.deleteById(id);
        logger.info("Room with ID {} deleted", id);
    }
}
