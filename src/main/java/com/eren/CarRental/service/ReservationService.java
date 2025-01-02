package com.eren.CarRental.service;

import com.eren.CarRental.model.Car;
import com.eren.CarRental.model.Reservation;
import com.eren.CarRental.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation createReservation(Car car, LocalDate startDate, LocalDate endDate) throws Exception {
        if (isCarAvailable(car.getId(), startDate, endDate)) {
            Reservation reservation = new Reservation();
            reservation.setCar(car);
            reservation.setStartDate(startDate);
            reservation.setEndDate(endDate);
            return reservationRepository.save(reservation);
        } else {
            throw new Exception("Car is already reserved for the selected dates.");
        }
    }

    public boolean isCarAvailable(Integer carId, LocalDate startDate, LocalDate endDate) {
        List<Reservation> overlappingReservations = reservationRepository
                .findByCarIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(carId, endDate, startDate);
        return overlappingReservations.isEmpty();
    }
}
