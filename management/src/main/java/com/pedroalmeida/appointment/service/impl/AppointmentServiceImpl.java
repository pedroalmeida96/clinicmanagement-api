package com.pedroalmeida.appointment.service.impl;

import com.pedroalmeida.appointment.model.entity.Appointment;
import com.pedroalmeida.appointment.model.repository.AppointmentRepository;
import com.pedroalmeida.appointment.service.AppointmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository repository;

    /**
     * Gets all appointment that are in the future/valid. If the appointment is no longer active its not returned.
     *
     * @return appointment
     */

    @Override
    public List<Appointment> getAllAppointments() {
        log.trace("Retrieving all appointment");
        return repository.findAll();
    }

    /**
     * Insert appointment in the repo.
     *
     * @param appointment
     */
    @Override
    public Appointment insertAppointment(Appointment appointment) {
        log.trace("Inserting appointment");
        repository.save(appointment);
        return appointment;
    }


    @Override
    public Optional<Appointment> getById(Long id) {
        log.trace("Retrieving appointment with appointment_id= " + id);
        return repository.findById(id);
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        repository.save(appointment);
        return appointment;
    }

    @Override
    @Transactional
    public void deleteAppointment(Appointment appointment) {
        log.trace("Deleting appointment with appointment_id= " + appointment.getId());
        Objects.requireNonNull(appointment.getId());
        repository.delete(appointment);
    }
}
