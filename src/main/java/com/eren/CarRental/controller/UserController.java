package com.eren.CarRental.controller;

import com.eren.CarRental.model.User;
import com.eren.CarRental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUser(@PathVariable String email) {
        Optional<User> user = userService.findUserByEmail(email);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String email, @RequestParam String password) {
        boolean isAuthenticated = userService.checkCredentials(email, password);
        return isAuthenticated ? ResponseEntity.ok("Login successful") : ResponseEntity.status(401).body("Invalid credentials");
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
        return ResponseEntity.ok("User deleted successfully");
    }
}
