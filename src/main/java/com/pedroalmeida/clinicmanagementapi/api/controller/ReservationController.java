package com.pedroalmeida.clinicmanagementapi.api.controller;


import com.pedroalmeida.clinicmanagementapi.model.entity.Reservation;
import com.pedroalmeida.clinicmanagementapi.model.enums.Mappings;
import com.pedroalmeida.clinicmanagementapi.service.ReservationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping(Mappings.API)
@AllArgsConstructor
public class ReservationController {

    private final ReservationService service;

    @GetMapping(Mappings.GET_ALL)
    public ResponseEntity<List<Reservation>> getAll() {
        log.trace("123");
        List<Reservation> list = service.getAllReservations();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(Mappings.GET_BY_ID)
    public ResponseEntity<Reservation> getReservation(@PathVariable("id") Long id) {
        Optional<Reservation> reservation = service.getById(id);
        return new ResponseEntity(reservation, HttpStatus.OK);
    }

    @PostMapping(Mappings.ADD_RESERVATION)
    public ResponseEntity<Reservation> putReservation(@RequestBody Reservation reservation) {
        return new ResponseEntity(service.insertReservation(reservation), HttpStatus.CREATED);
    }

    @PutMapping(Mappings.UPDATE_RESERVATION)
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation) {
        return new ResponseEntity(service.updateReservation(reservation), HttpStatus.OK);
    }

    @RequestMapping(value = Mappings.DELETE_RESERVATION, method = {RequestMethod.DELETE})
    public ResponseEntity deleteReservation(@PathVariable("id") long id) {
        return service.getById(id).map(entity -> {
            service.deleteReservation(entity);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }).orElseGet(() ->
                new ResponseEntity("Transaction not found.", HttpStatus.BAD_REQUEST));
    }

}

