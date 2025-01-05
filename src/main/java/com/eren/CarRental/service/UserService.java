package com.eren.CarRental.service;

import com.eren.CarRental.model.User;
import com.eren.CarRental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    private BCryptPasswordEncoder passwordEncoder;

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encrypt password
        return userRepository.save(user);
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findById(email);
    }

    public boolean checkCredentials(String email, String rawPassword) {
        Optional<User> userOptional = userRepository.findById(email);
        if (userOptional.isPresent()) {
            return passwordEncoder.matches(rawPassword, userOptional.get().getPassword());
        }
        return false;
    }

    public void deleteUser(String email) {
        userRepository.deleteById(email);
    }
}
