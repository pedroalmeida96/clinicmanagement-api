package com.pedroalmeida.appointment.controller;


import com.pedroalmeida.appointment.model.entity.Appointment;
import com.pedroalmeida.appointment.service.AppointmentService;
import com.pedroalmeida.shared.Mappings;
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
public class AppointmentController {

    private final AppointmentService service;

    @GetMapping(Mappings.GET_ALL_APPOINTMENTS)
    public ResponseEntity<List<Appointment>> getAll() {
        List<Appointment> list = service.getAllAppointments();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(Mappings.GET_APPOINTMENTS_BY_ID)
    public ResponseEntity<Appointment> getAppointment(@PathVariable("id") Long id) {
        Optional<Appointment> appointment = service.getById(id);
        return new ResponseEntity(appointment, HttpStatus.OK);
    }

    @PostMapping(Mappings.ADD_APPOINTMENT)
    public ResponseEntity<Appointment> putAppointment(@RequestBody Appointment appointment) {
        return new ResponseEntity(service.insertAppointment(appointment), HttpStatus.CREATED);
    }

    @PutMapping(Mappings.UPDATE_APPOINTMENT)
    public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment) {
        return new ResponseEntity(service.updateAppointment(appointment), HttpStatus.OK);
    }

    @RequestMapping(value = Mappings.DELETE_APPOINTMENT, method = {RequestMethod.DELETE})
    public ResponseEntity deleteAppointment(@PathVariable("id") long id) {
        return service.getById(id).map(entity -> {
            service.deleteAppointment(entity);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }).orElseGet(() ->
                new ResponseEntity("Appointment not found.", HttpStatus.BAD_REQUEST));
    }

}

