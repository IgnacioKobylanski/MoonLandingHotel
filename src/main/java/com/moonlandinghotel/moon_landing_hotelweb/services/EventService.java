package com.moonlandinghotel.moon_landing_hotelweb.services;

import com.moonlandinghotel.moon_landing_hotelweb.models.Event;
import com.moonlandinghotel.moon_landing_hotelweb.repositories.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private static final Logger logger = LoggerFactory.getLogger(EventService.class);

    @Autowired
    private EventRepository eventRepository;

    // Obtener todos los eventos
    public List<Event> getAllEvents() {
        logger.info("Fetching all events");
        List<Event> events = eventRepository.findAll();
        logger.info("Found {} events", events.size());
        return events;
    }

    // Obtener evento por ID
    public Optional<Event> getEventById(Long id) {
        logger.info("Fetching event with ID: {}", id);
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            logger.info("Found event: {}", event.get().getName());
        } else {
            logger.warn("Event with ID {} not found", id);
        }
        return event;
    }

    // Crear o actualizar evento
    public Event saveEvent(Event event) {
        logger.info("Saving event: {}", event.getName());

        if (event.getName() == null || event.getName().isEmpty()) {
            logger.error("Event name can't be null or empty");
            throw new IllegalArgumentException("Event name can't be null or empty");
        }

        if (event.getPrice() < 0) {
            logger.error("Price can't be negative for event: {}", event.getName());
            throw new IllegalArgumentException("Price can't be negative");
        }

        Event savedEvent = eventRepository.save(event);
        logger.info("Event saved with ID: {}", savedEvent.getId());
        return savedEvent;
    }

    // Eliminar evento por ID
    public void deleteEventById(Long id) {
        logger.info("Deleting event with ID: {}", id);

        if (id == null) {
            logger.error("The ID can't be null");
            throw new IllegalArgumentException("The ID can't be null");
        }

        if (!eventRepository.existsById(id)) {
            logger.error("The Event with ID {} doesn't exist.", id);
            throw new RuntimeException("The Event with id: " + id + " doesn't exist.");
        }

        eventRepository.deleteById(id);
        logger.info("Event with ID {} deleted", id);
    }
}
