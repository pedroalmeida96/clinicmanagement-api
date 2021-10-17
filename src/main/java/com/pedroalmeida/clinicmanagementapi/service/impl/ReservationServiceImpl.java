package com.pedroalmeida.clinicmanagementapi.service.impl;

import com.pedroalmeida.clinicmanagementapi.model.entity.Reservation;
import com.pedroalmeida.clinicmanagementapi.model.repository.ReservationRepository;
import com.pedroalmeida.clinicmanagementapi.service.ReservationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ReservationServiceImpl implements ReservationService {

    ReservationRepository repository;

    /**
     * Gets all reservations that are in the future/valid. If the reservation is no longer active its not returned.
     *
     * @return reservations
     */

    @Override
    public List<Reservation> getAllReservations() {
        log.trace("Retrieving all reservations");
        return repository.findAll();
    }

    /**
     * Insert reservation in the repo.
     *
     * @param reservation
     */
    @Override
    public Reservation insertReservation(Reservation reservation) {
        repository.save(reservation);
        return reservation;
    }


    @Override
    public Optional<Reservation> getById(Long id) {
        log.trace("Retrieving reservation with reservation_id= " + id);
        return repository.findById(id);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        repository.save(reservation);
        return reservation;
    }

    @Override
    @Transactional
    public void deleteReservation(Reservation reservation) {
        log.trace("Deleting reservation with reservation_id= " + reservation.getId());
        Objects.requireNonNull(reservation.getId());
        repository.delete(reservation);
    }
}
