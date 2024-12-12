package com.moonlandinghotel.moon_landing_hotelweb.controllers;

import com.moonlandinghotel.moon_landing_hotelweb.models.Event;
import com.moonlandinghotel.moon_landing_hotelweb.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    // GET /api/events - Obtener todos los eventos
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    // GET /api/events/{id} - Obtener un evento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Optional<Event> event = eventService.getEventById(id);
        if (event.isPresent()) {
            return ResponseEntity.ok(event.get()); // Devuelve 200 OK con el evento
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Devuelve 404 si no se encuentra
        }
    }

    // POST /api/events - Crear un nuevo evento
    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.saveEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent); // Devuelve 201 Created
    }

    // PUT /api/events/{id} - Actualizar un evento existente
    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event event) {
        event.setId(id); // Aseguramos que el ID del evento coincida
        Event updatedEvent = eventService.saveEvent(event);
        return ResponseEntity.ok(updatedEvent); // Devuelve 200 OK con el evento actualizado
    }

    // DELETE /api/events/{id} - Eliminar un evento por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEventById(id);
        return ResponseEntity.noContent().build(); // Devuelve 204 No Content (sin cuerpo)
    }
}
