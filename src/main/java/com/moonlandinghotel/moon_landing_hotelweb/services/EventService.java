package com.moonlandinghotel.moon_landing_hotelweb.services;

import com.moonlandinghotel.moon_landing_hotelweb.models.Event;
import com.moonlandinghotel.moon_landing_hotelweb.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    //todos los eventos
    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    //evento por id
    public Optional<Event> getEventById(Long id){
        return eventRepository.findById(id);
    }

    //crer o actualizar
    public Event saveEvent(Event event) {
        if (event.getName() == null || event.getName().isEmpty()) {
            throw new IllegalArgumentException("Event name can't be null or empty");
        }
        if (event.getPrice() < 0) {
            throw new IllegalArgumentException("Price can't be negative");
        }
        return eventRepository.save(event);
    }

    //eliminar
    public void deleteEventById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("The ID can't be null");
        }
        if (!eventRepository.existsById(id)) {
            throw new RuntimeException("The Event with id:  " + id + " doesn't exist.");
        }
        eventRepository.deleteById(id);
    }

}
