package com.moonlandinghotel.moon_landing_hotelweb.controllers;

import com.moonlandinghotel.moon_landing_hotelweb.models.User;
import com.moonlandinghotel.moon_landing_hotelweb.services.UserService;
import com.moonlandinghotel.moon_landing_hotelweb.security.config.JwtUtil;  // Asegúrate de importar JwtUtil
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;  // genera el token

    // POST /api/users/login - Validar credenciales de usuario y devolver el JWT
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        Optional<User> user = userService.validateLogin(loginRequest.getEmail(), loginRequest.getPassword());
        if (user.isPresent()) {
            // Generar el token JWT
            String token = jwtUtil.generateToken(user.get().getEmail());

            // Crear un mapa con el token y los detalles del usuario (incluyendo admin)
            return ResponseEntity.ok(Map.of(
                    "token", token,  // El token JWT generado
                    "name", user.get().getName(),
                    "lastname", user.get().getLastname(),  // Asegúrate de incluir el lastname
                    "email", user.get().getEmail(),
                    "id", user.get().getId(),
                    "admin", user.get().isAdmin()  // Incluyendo admin
            ));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Devuelve 401 si las credenciales son incorrectas
        }
    }
}
