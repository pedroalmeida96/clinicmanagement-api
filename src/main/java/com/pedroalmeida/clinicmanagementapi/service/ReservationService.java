package com.pedroalmeida.clinicmanagementapi.service;

import com.pedroalmeida.clinicmanagementapi.model.entity.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    Reservation updateReservation(Reservation reservation);

    void deleteReservation(Reservation reservation);

    Reservation insertReservation(Reservation reservation);

    Optional<Reservation> getById(Long id);

    List<Reservation> getAllReservations();
}
