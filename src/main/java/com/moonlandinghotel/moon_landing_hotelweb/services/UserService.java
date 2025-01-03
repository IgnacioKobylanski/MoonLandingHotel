package com.moonlandinghotel.moon_landing_hotelweb.services;

import com.moonlandinghotel.moon_landing_hotelweb.models.User;
import com.moonlandinghotel.moon_landing_hotelweb.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    // Obtener todos los usuarios
    public List<User> getAllUsers() {
        logger.info("Fetching all users");
        List<User> users = userRepository.findAll();
        logger.info("Found {} users", users.size());
        return users;
    }

    // Obtener usuario por ID
    public Optional<User> getUserById(Long id) {
        logger.info("Fetching user with ID: {}", id);
        if (id == null) {
            logger.error("The ID can't be null");
            throw new IllegalArgumentException("The ID can't be null");
        }
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            logger.info("Found user: {}", user.get().getEmail());
        } else {
            logger.warn("User with ID {} not found", id);
        }
        return user;
    }

    // Crear o actualizar usuario
    public User saveUser(User user) {
        logger.info("Saving user with email: {}", user.getEmail());

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            logger.error("Email can't be null or empty");
            throw new IllegalArgumentException("Email can't be null or empty");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            logger.error("Password can't be null or empty");
            throw new IllegalArgumentException("Password can't be null or empty");
        }

        User savedUser = userRepository.save(user);
        logger.info("User saved with ID: {}", savedUser.getId());
        return savedUser;
    }

    // Eliminar usuario por ID
    public void deleteUserById(Long id) {
        logger.info("Deleting user with ID: {}", id);

        if (id == null) {
            logger.error("The ID can't be null");
            throw new IllegalArgumentException("The ID can't be null");
        }

        if (!userRepository.existsById(id)) {
            logger.error("The User with ID {} doesn't exist.", id);
            throw new RuntimeException("The User with ID " + id + " doesn't exist.");
        }

        userRepository.deleteById(id);
        logger.info("User with ID {} deleted", id);
    }

    // Validar login por email y password
    public Optional<User> validateLogin(String email, String password) {
        logger.info("Validating login for email: {}", email);

        if (email == null || email.isEmpty()) {
            logger.error("Email can't be null or empty");
            throw new IllegalArgumentException("Email can't be null or empty");
        }
        if (password == null || password.isEmpty()) {
            logger.error("Password can't be null or empty");
            throw new IllegalArgumentException("Password can't be null or empty");
        }

        // Busca al usuario por email y contraseña
        return userRepository.findByEmailAndPassword(email, password);
    }

}
