package com.eren.CarRental.repository;

import com.eren.CarRental.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    List<Reservation> findByCarIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            Integer carId, LocalDate endDate, LocalDate startDate);
}
