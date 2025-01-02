package com.eren.CarRental.controller;

import com.eren.CarRental.model.Car;
import com.eren.CarRental.model.Reservation;
import com.eren.CarRental.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public String createReservation(@RequestParam Integer carId,
                                    @RequestParam String startDate,
                                    @RequestParam String endDate) {
        try {
            // Assuming you fetch the car from a CarService (not implemented here)
            Car car = new Car();
            car.setId(carId);
            reservationService.createReservation(car, LocalDate.parse(startDate), LocalDate.parse(endDate));
            return "Reservation created successfully.";
        } catch (Exception e) {
            return "Failed to create reservation: " + e.getMessage();
        }
    }
}
