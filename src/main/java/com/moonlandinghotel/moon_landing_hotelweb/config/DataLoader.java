package com.moonlandinghotel.moon_landing_hotelweb.config;

import com.moonlandinghotel.moon_landing_hotelweb.models.Event;
import com.moonlandinghotel.moon_landing_hotelweb.models.Room;
import com.moonlandinghotel.moon_landing_hotelweb.models.User;
import com.moonlandinghotel.moon_landing_hotelweb.services.EventService;
import com.moonlandinghotel.moon_landing_hotelweb.services.RoomService;
import com.moonlandinghotel.moon_landing_hotelweb.services.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    @Autowired
    private UserService userService;

    @Autowired
    private EventService eventService;

    @Autowired
    private RoomService roomService;

    @PostConstruct
    public void loadUsers() {
        if (userService.getAllUsers().isEmpty()) {
            userService.saveUser(new User("pepe@mail.com", "pepe1234", "Pepe", "Pérez", false));
            userService.saveUser(new User("carlo@mail.com", "carlo1234", "Carlo", "Gómez", false));
            userService.saveUser(new User("pedro@mail.com", "pedro1234", "Pedro", "López", false));
            userService.saveUser(new User("bustamante@mail.com", "busta1234", "Bustamante", "Roller", false));
            userService.saveUser(new User("charston@mail.com", "charston1234", "Carlos", "Charleston", false));
            userService.saveUser(new User("preston@mail.com", "preston1234", "Preston", "Smith", true));

            System.out.println("Users successfully loaded into the database.");
        } else {
            System.out.println("The database already contains users. No duplicate data was loaded.");
        }
    }

    @PostConstruct
    public void loadEvents() {
        // Check if there are already events in the database
        if (eventService.getAllEvents().isEmpty()) {
            // Load events only if the table is empty
            eventService.saveEvent(new Event("Ted Talk", "Ted Talk is coming to town and is waiting for you!",
                    "Do you want to waste your time listening to weird people?, look no further.",
                    550, 15, "May",
                    "https://images.pexels.com/photos/2774556/pexels-photo-2774556.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
            eventService.saveEvent(new Event("Ted Talk", "Ted Talk is coming to town and is waiting for you!",
                    "Do you want to waste your time listening to weird people?, look no further.",
                    550, 15, "May",
                    "https://images.pexels.com/photos/2774556/pexels-photo-2774556.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
            eventService.saveEvent(new Event("Ted Talk", "Ted Talk is coming to town and is waiting for you!",
                    "Do you want to waste your time listening to weird people?, look no further.",
                    550, 15, "May",
                    "https://images.pexels.com/photos/2774556/pexels-photo-2774556.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));

            System.out.println("Events successfully loaded into the database.");
        } else {
            System.out.println("The database already contains events. No duplicate data was loaded.");
        }
    }

    @PostConstruct
    public void loadRooms() {
        if (roomService.getAllRooms().isEmpty()) {
            roomService.saveRoom(new Room("Standard room", 100,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    "https://images.pexels.com/photos/172872/pexels-photo-172872.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
            roomService.saveRoom(new Room("Suite", 500,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    "https://images.pexels.com/photos/7031731/pexels-photo-7031731.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
            roomService.saveRoom(new Room("Deluxe Suit", 1000,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    "https://images.pexels.com/photos/10681894/pexels-photo-10681894.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));

            roomService.saveRoom(new Room("Old World", 750,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    "https://images.pexels.com/photos/15011341/pexels-photo-15011341/free-photo-of-kocatas-de-seis-sentidos.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));

            roomService.saveRoom(new Room("Classic", 450,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    "https://images.pexels.com/photos/271639/pexels-photo-271639.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));

            roomService.saveRoom(new Room("Economic", 250,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    "https://images.pexels.com/photos/1457842/pexels-photo-1457842.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));

            roomService.saveRoom(new Room("Honeymoon Haven Room", 500,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    "https://images.pexels.com/photos/1838554/pexels-photo-1838554.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));

            roomService.saveRoom(new Room("North Star Suite", 1200,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    "https://images.pexels.com/photos/27626174/pexels-photo-27626174/free-photo-of-vacaciones-relajacion-hotel-cama.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));

            roomService.saveRoom(new Room("Golden Horizon Suite", 250,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    "https://images.pexels.com/photos/14746032/pexels-photo-14746032.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));

            roomService.saveRoom(new Room("Serene Sky Room", 50,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    "https://images.pexels.com/photos/19467973/pexels-photo-19467973/free-photo-of-hotel-cama-habitacion-viaje.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));

            System.out.println("Rooms successfully loaded into the database.");
        } else {
            System.out.println("The database already contains rooms. No duplicate data was loaded.");
        }
    }
}
