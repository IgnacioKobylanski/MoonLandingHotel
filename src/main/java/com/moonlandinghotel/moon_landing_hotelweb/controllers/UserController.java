package com.moonlandinghotel.moon_landing_hotelweb.controllers;

import com.moonlandinghotel.moon_landing_hotelweb.models.User;
import com.moonlandinghotel.moon_landing_hotelweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // GET /api/users - Obtener todos los usuarios
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // GET /api/users/{id} - Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get()); // Devuelve 200 OK y el usuario
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Devuelve 404 si no se encuentra
        }
    }

    // POST /api/users/login - Validar credenciales de usuario
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User loginRequest) {
        Optional<User> user = userService.validateLogin(loginRequest.getEmail(), loginRequest.getPassword());
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get()); // Devuelve 200 OK si las credenciales son correctas
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Devuelve 401 si las credenciales son incorrectas
        }
    }

    // POST /api/users - Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser); // Devuelve 201 Created
    }

    // PUT /api/users/{id} - Actualizar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id); // Aseguramos que el ID del usuario coincida
        User updatedUser = userService.saveUser(user);
        return ResponseEntity.ok(updatedUser); // Devuelve 200 OK con el usuario actualizado
    }

    // DELETE /api/users/{id} - Eliminar un usuario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build(); // Devuelve 204 No Content (sin cuerpo)
    }
}
