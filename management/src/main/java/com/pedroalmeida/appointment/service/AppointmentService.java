package com.pedroalmeida.appointment.service;

import com.pedroalmeida.appointment.model.entity.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    Appointment updateAppointment(Appointment appointment);

    void deleteAppointment(Appointment appointment);

    Appointment insertAppointment(Appointment appointment);

    Optional<Appointment> getById(Long id);

    List<Appointment> getAllAppointments();
}
