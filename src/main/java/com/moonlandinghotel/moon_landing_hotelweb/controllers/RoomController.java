package com.moonlandinghotel.moon_landing_hotelweb.controllers;

import com.moonlandinghotel.moon_landing_hotelweb.models.Room;
import com.moonlandinghotel.moon_landing_hotelweb.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    // GET /api/rooms - Obtener todos los cuartos
    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    // GET /api/rooms/{id} - Obtener un cuarto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
        Optional<Room> room = roomService.getRoomById(id);
        if (room.isPresent()) {
            return ResponseEntity.ok(room.get()); // Devuelve 200 OK con el cuarto
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Devuelve 404 si no se encuentra
        }
    }

    // POST /api/rooms - Crear un nuevo cuarto
    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        Room createdRoom = roomService.saveRoom(room);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRoom); // Devuelve 201 Created
    }

    // PUT /api/rooms/{id} - Actualizar un cuarto existente
    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody Room room) {
        room.setId(id); // Aseguramos que el ID del cuarto coincida
        Room updatedRoom = roomService.saveRoom(room);
        return ResponseEntity.ok(updatedRoom); // Devuelve 200 OK con el cuarto actualizado
    }

    // DELETE /api/rooms/{id} - Eliminar un cuarto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoomById(id);
        return ResponseEntity.noContent().build(); // Devuelve 204 No Content (sin cuerpo)
    }
}
