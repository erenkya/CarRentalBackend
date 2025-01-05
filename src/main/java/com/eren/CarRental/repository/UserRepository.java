package com.eren.CarRental.repository;

import com.eren.CarRental.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
}
