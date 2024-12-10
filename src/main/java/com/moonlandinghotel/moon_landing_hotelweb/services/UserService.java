package com.moonlandinghotel.moon_landing_hotelweb.services;

import com.moonlandinghotel.moon_landing_hotelweb.models.User;
import com.moonlandinghotel.moon_landing_hotelweb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //todos los usuarios
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //usuario por id
    public Optional<User> getUserById(Long id){
        if (id == null) {
            throw new IllegalArgumentException("The ID can't be null");
        }
        return userRepository.findById(id);
    }

    //crer o actualizar
    public User saveUser(User user){
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email can't be null or empty");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password can't be null or empty");
        }
        return userRepository.save(user);
    }

    //eliminar
    public void deleteUserById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("The ID can't be null");
        }
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("The User with ID " + id + " doesn't exist.");
        }
        userRepository.deleteById(id);
    }
}
