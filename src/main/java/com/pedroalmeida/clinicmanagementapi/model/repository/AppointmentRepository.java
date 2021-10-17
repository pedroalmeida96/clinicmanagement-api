package com.pedroalmeida.clinicmanagementapi.model.repository;

import com.pedroalmeida.clinicmanagementapi.model.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    void deleteAppointmentById(Long id);

    Optional<Appointment> getAppointmentById(Long id);
}

