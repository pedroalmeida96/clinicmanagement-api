package com.pedroalmeida.clinicmanagementapi.model.repository;

import com.pedroalmeida.clinicmanagementapi.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    void deleteReservationById(Long id);

    Optional<Reservation> getReservationById(Long id);
}

